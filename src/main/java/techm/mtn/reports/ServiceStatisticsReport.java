//package techm.mtn.reports;
//
//import com.bea.wli.config.Ref;
//import com.bea.wli.monitoring.DomainMonitoringDisabledException;
//import com.bea.wli.monitoring.InvalidServiceRefException;
//import com.bea.wli.monitoring.MonitoringException;
//import com.bea.wli.monitoring.MonitoringNotEnabledException;
//import com.bea.wli.monitoring.ResourceStatistic;
//import com.bea.wli.monitoring.ResourceType;
//import com.bea.wli.monitoring.ServiceDomainMBean;
//import com.bea.wli.monitoring.ServiceResourceStatistic;
//import com.bea.wli.monitoring.StatisticType;
//import com.bea.wli.monitoring.StatisticValue;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//import java.io.IOException;
//
//import java.io.InputStream;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//import java.net.MalformedURLException;
//
//import java.text.DecimalFormat;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.management.MBeanServerConnection;
//import javax.management.MalformedObjectNameException;
//import javax.management.ObjectName;
//import javax.management.remote.JMXConnector;
//import javax.management.remote.JMXConnectorFactory;
//import javax.management.remote.JMXServiceURL;
//
//import javax.naming.Context;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import weblogic.management.jmx.MBeanServerInvocationHandler;
//
//
//public class ServiceStatisticsReport {
//    private ServiceDomainMBean serviceDomainMbean = null;
//    private Ref[] proxyServiceRefs;
//    private Ref[] filteredProxyServiceRefs;
//    private Ref[] businessServiceRefs;
//    private Ref[] filteredBusinessServiceRefs;
//    private int rowCtr = 0;
//    private int collCtr = 0;
//    Properties prop = new Properties();
//    InputStream input = null;
//
//    private void initServiceDomainMBean(String host, int port, String username, String password) throws Exception {
//        InvocationHandler handler = new ServiceDomainMBeanInvocationHandler(host, port, username, password);
//        Object proxy = Proxy.newProxyInstance(ServiceDomainMBean.class.getClassLoader(), new Class[]{ServiceDomainMBean.class}, handler);
//
//        serviceDomainMbean = (ServiceDomainMBean) proxy;
//    }
//
//
//    public static class ServiceDomainMBeanInvocationHandler implements InvocationHandler {
//        private String jndiURL = "weblogic.management.mbeanservers.domainruntime";
//
//        private String protocol = "t3";
//        private String hostname = "localhost";
//        private int port = 7001;
//        private String jndiRoot = "/jndi/";
//
//        private String username = "weblogic";
//        private String password = "weblogic";
//
//        private JMXConnector conn = null;
//        private Object actualMBean = null;
//
//
//        public ServiceDomainMBeanInvocationHandler(String hostName, int port, String userName, String password) {
//            this.hostname = hostName;
//            this.port = port;
//            this.username = userName;
//            this.password = password;
//        }
//
//
//        public JMXConnector initConnection() throws IOException, MalformedURLException {
//            JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname, port, jndiRoot + jndiURL);
//            Hashtable h = new Hashtable();
//
//            if (username != null) h.put(Context.SECURITY_PRINCIPAL, username);
//            if (password != null) h.put(Context.SECURITY_CREDENTIALS, password);
//
//            h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
//
//            return JMXConnectorFactory.connect(serviceURL, h);
//        }
//
//        /**
//         * Invokes specified method with specified params on specified
//         * object.
//         */
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            if (conn == null) conn = initConnection();
//
//            if (actualMBean == null) actualMBean = findServiceDomain(conn.getMBeanServerConnection());
//
//            return method.invoke(actualMBean, args);
//        }
//
//
//        public Object findServiceDomain(MBeanServerConnection connection) {
//            try {
//                ObjectName on = new ObjectName(ServiceDomainMBean.OBJECT_NAME);
//                return MBeanServerInvocationHandler.newProxyInstance(connection, on);
//            } catch (MalformedObjectNameException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//    }
//
//    public ServiceStatisticsReport() {
//        super();
//        String Excelfilepath = "C:/Temp/MTN_NG12c_SERVICELOG2_Test1.xlsx";
//        try {
//            //XSSFWorkbook workbook = new XSSFWorkbook();
//            //XSSFSheet sheet = workbook.createSheet("Nigeria Daily Report");
//
//            FileInputStream inputFile = new FileInputStream(new File(Excelfilepath)); //  XLS file
//            XSSFWorkbook newWorkbook = new XSSFWorkbook(inputFile); //create a blank workbook object
//            inputFile.close();
//            int totalSheets = newWorkbook.getNumberOfSheets();
//
//
//            for (int j = 0; j < totalSheets; ++j) {
//                XSSFSheet sheet1 = newWorkbook.getSheetAt(j); /*
//                /* Create Connection objects */
//                if (sheet1.getSheetName().equalsIgnoreCase("Trade Service Health")) {
//                    System.out.println("==START==============================Trade Service Health=====================================");
//                    input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/TradeServiceHealth.properties");
//                    prop.load(input);
//
//                    if (prop.getProperty("TradeServiceHealth").equalsIgnoreCase("true")) {
//                        System.out.println("TradeServiceHealth:" + prop.getProperty("TradeServiceHealth"));
//
//                        String[] arrayResourceNames = {"Initialization_request", "Enrichment_request", "RouteToADatabaseProcedure", "Enrichment_response", "Initialization_response"};
//                        List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                        initServiceDomainMBean(prop.getProperty("HOSTNAME"), Integer.parseInt(prop.getProperty("PORT")), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
//
//                        System.out.println("WebLogic Server Details : " + prop.getProperty("HOSTNAME") + ":" + prop.getProperty("PORT"));
//
//                        getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                        getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//
//
//                    }
//                    System.out.println("==END================================Trade Service Health=====================================");
//
//
//                } else if (sheet1.getSheetName().equalsIgnoreCase("Customer Service Health")) {
//
//                    System.out.println("==START==============================Customer Service Health=====================================");
//                    input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/CustomerServiceHealth.properties");
//                    prop.load(input);
//
//                    if (prop.getProperty("CustomerServiceHealth").equalsIgnoreCase("true")) {
//                        System.out.println("CustomerServiceHealth:" + prop.getProperty("CustomerServiceHealth"));
//
//                        String[] arrayResourceNames = {"Initialization_request", "Enrichment_request", "RouteToADatabaseProcedure", "Enrichment_response", "Initialization_response"};
//                        List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                        initServiceDomainMBean(prop.getProperty("HOSTNAME"), Integer.parseInt(prop.getProperty("PORT")), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
//
//                        System.out.println("WebLogic Server Details : " + prop.getProperty("HOSTNAME") + ":" + prop.getProperty("PORT"));
//                        getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                        getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//
//                    }
//                    System.out.println("==END================================Customer Service Health=====================================");
//
//                } else if (sheet1.getSheetName().equalsIgnoreCase("Digital Service Health")) {
//
//                    System.out.println("==START==============================Digital Service Health=====================================");
//                    input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/DigitalServiceHealth.properties");
//                    prop.load(input);
//
//                    if (prop.getProperty("DigitalServiceHealth").equalsIgnoreCase("true")) {
//                        System.out.println("DigitalServiceHealth:" + prop.getProperty("DigitalServiceHealth"));
//
//                        String[] arrayResourceNames = {"Initialization_request", "Enrichment_request", "RouteToADatabaseProcedure", "Enrichment_response", "Initialization_response"};
//                        List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                        initServiceDomainMBean(prop.getProperty("HOSTNAME"), Integer.parseInt(prop.getProperty("PORT")), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
//
//                        System.out.println("WebLogic Server Details : " + prop.getProperty("HOSTNAME") + ":" + prop.getProperty("PORT"));
//                        getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                        getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//
//                    }
//                    System.out.println("==END================================Digital Service Health=====================================");
//
//                } else if (sheet1.getSheetName().equalsIgnoreCase("External Service Health")) {
//
//                    System.out.println("==START==============================External Service Health=====================================");
//                    input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/ExternalServiceHealth.properties");
//                    prop.load(input);
//
//                    if (prop.getProperty("ExternalServiceHealth").equalsIgnoreCase("true")) {
//                        System.out.println("ExternalServiceHealth:" + prop.getProperty("ExternalServiceHealth"));
//
//                        String[] arrayResourceNames = {"Initialization_request", "Enrichment_request", "RouteToADatabaseProcedure", "Enrichment_response", "Initialization_response"};
//                        List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                        initServiceDomainMBean(prop.getProperty("HOSTNAME"), Integer.parseInt(prop.getProperty("PORT")), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
//
//                        System.out.println("WebLogic Server Details : " + prop.getProperty("HOSTNAME") + ":" + prop.getProperty("PORT"));
//                        getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                        getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//
//                    }
//                    System.out.println("==END================================External Service Health=====================================");
//
//                }
//              /*
//                else if (sheet1.getSheetName().equalsIgnoreCase("Single NIN Service Health")){
//
//                    System.out.println("==START==============================Single NIN Service Health=====================================");
//                    input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/SingleNINServiceHealth.properties");
//                    prop.load(input);
//
//                    if(prop.getProperty("SingleNINServiceHealth").equalsIgnoreCase("true")){
//                        System.out.println("SingleNINServiceHealth:" + prop.getProperty("SingleNINServiceHealth"));
//                        String[] arrayResourceNames =
//                        { "Initialization_request", "Enrichment_request",
//                          "RouteToADatabaseProcedure", "Enrichment_response",
//                          "Initialization_response" };
//                        List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                        initServiceDomainMBean("ikyesfninadmin01",
//                                               Integer.parseInt("7001"),
//                                               "TechMOffshore",
//                                               "TechMOffshore@321");
//
//                        System.out.println("WebLogic Server Details : " +
//                                           prop.getProperty("HOSTNAME") + ":" +
//                                           prop.getProperty("PORT"));
//                        getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                        getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//
//
//
//                    }
//                    System.out.println("==END================================Single NIN Service Health=====================================");
//                }
//            else if (sheet1.getSheetName().equalsIgnoreCase("Bulk NIN Service Health")){
//
//                System.out.println("==START============================== Bulk NIN Service Health=====================================");
//                input = new FileInputStream(System.getProperty("user.dir") + "" + "/src/techm/mtn/reports/BulkNINServiceHealth.properties");
//                prop.load(input);
//
//                if(prop.getProperty("BulkNINServiceHealth").equalsIgnoreCase("true")){
//                    System.out.println("BulkNINServiceHealth:" + prop.getProperty("BulkNINServiceHealth"));
//                    String[] arrayResourceNames =
//                    { "Initialization_request", "Enrichment_request",
//                      "RouteToADatabaseProcedure", "Enrichment_response",
//                      "Initialization_response" };
//                    List filteredResourceNames = Arrays.asList(arrayResourceNames);
//
//                    initServiceDomainMBean("ikyesfmftadmin01",
//                                           Integer.parseInt("7001"),
//                                           "TechMOffshore",
//                                           "TechMOffshore@123");
//
//                    System.out.println("WebLogic Server Details : " +
//                                       prop.getProperty("HOSTNAME") + ":" +
//                                       prop.getProperty("PORT"));
//                    getBusinessServiceDetails(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                    getProxyServiceDetails_CustomerService(sheet1, prop, filteredResourceNames, rowCtr, collCtr);
//                }
//                System.out.println("==END================================ Bulk NIN Service Health=====================================");
//            }*/
//            }
//
//            try {
//                FileOutputStream outputFile = new FileOutputStream(new File(Excelfilepath)); //create XLS file
//                newWorkbook.write(outputFile); //write excel document to output stream
//                outputFile.close(); //close the file
//                System.out.println("Excel with foumula cells written successfully");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Finished");
//            refreshExcelFormulaCells(Excelfilepath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void getProxyServiceDetails_ESFRealTime1ServiceHealth(XSSFSheet sheet1, Properties prop, List filteredResourceNames, int rowCtr, int collCtr) {
//        String msgCount = "";
//        String errorCount = "";
//        String errorRatio = "";
//        try {
//            proxyServiceRefs = serviceDomainMbean.getMonitoredProxyServiceRefs();
//
//            if (proxyServiceRefs != null && proxyServiceRefs.length != 0) {
//
//                int proxySize = Integer.parseInt(prop.getProperty("ServicePS"));
//                filteredProxyServiceRefs = new Ref[proxySize];
//                int ctrPS = 0;
//                for (int i = 0; i < proxyServiceRefs.length; i++) {
//                    //filteredProxyServiceRefs[i] = proxyServiceRefs[i];
//                    //System.out.println("proxyServiceRefs[i].getFullName()-->" + proxyServiceRefs[i].getFullName());
//                    //String serviceName = proxyServiceRefs[i].getFullName().substring(proxyServiceRefs[i].getFullName().lastIndexOf("/") + 1);
//
//                    for (int ictr = 0; ictr < proxySize; ictr++) {
//                        String fileTmp1 = prop.getProperty("ProxyService" + (ictr + 1));
//                        String fileWithPath1 = fileTmp1.substring(0, fileTmp1.lastIndexOf("@@"));
//                        //System.out.println("CCCCCCCCC-->" +ictr + "<-->" + fileTmp1);
//                        if (proxyServiceRefs[i].getFullName().equalsIgnoreCase(fileWithPath1)) {
//                            filteredProxyServiceRefs[ictr] = proxyServiceRefs[i];
//                            //System.out.println("MATCHED-->" +proxyServiceRefs[i].getFullName());
//                            ctrPS = ctrPS + 1;
//                        }
//                    }
//
//                }
//                System.out.println("=================================================");
//                System.out.println("PS Started...");
//                int icp1 = 0;
//                for (ResourceType resourceType : ResourceType.values()) {
//                    if (icp1 == 0) {
//                        // Only process the following resource types: SERVICE,FLOW_COMPONENT,WEBSERVICE_OPERATION
//                        if (resourceType.name().equalsIgnoreCase("URI")) {
//                            continue;
//                        }
//                        HashMap proxyServiceResourceStatisticMap;
//                        proxyServiceResourceStatisticMap = serviceDomainMbean.getProxyServiceStatistics(filteredProxyServiceRefs, resourceType.value(), null);
//
//                        System.out.println("======= proxyServiceResourceStatisticMap.size(): " + proxyServiceResourceStatisticMap.size());
//
//                        Iterator it = proxyServiceResourceStatisticMap.entrySet().iterator();
//                        //out.write("\n=========================================");
//                        while (it.hasNext()) {
//
//                            Map.Entry mapEntry = (Map.Entry) it.next();
//                            String proxyNameStr = String.valueOf(mapEntry.getKey());
//
//                            String serviceName = proxyNameStr.substring(proxyNameStr.lastIndexOf("/") + 1);
//                            proxyNameStr = proxyNameStr.substring(proxyNameStr.indexOf(" ") + 1, proxyNameStr.length());
//                            //System.out.println("serviceName--------->" + serviceName);
//                            //if(serviceName.contains("UpdateCustomerDetailsAGLProvABCSPSv1.1.0")){
//                            //    System.out.println("serviceName--------->" + serviceName);
//                            //}
//                            //
//                            String rowCtrVal = getRowCount(prop, "ServicePS", "ProxyService", proxyNameStr);
//                            rowCtr = Integer.parseInt(rowCtrVal);
//                            XSSFRow row1 = sheet1.getRow(rowCtr);
//                            XSSFCell r1c1 = null;
//
//                            collCtr = 1;
//
//                            //System.out.println("======= Printing statistics for service getKey: " + mapEntry.getKey() +" and resourceType: " + mapEntry.getValue() + " =======");
//
//                            ServiceResourceStatistic serviceStats = (ServiceResourceStatistic) mapEntry.getValue();
//                            try {
//                                ResourceStatistic[] resStatsArray = serviceStats.getAllResourceStatistics();
//
//                                for (ResourceStatistic resStats : resStatsArray) {
//
//                                    if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !filteredResourceNames.contains(resStats.getName())) {
//                                        continue;
//                                    }
//                                    if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !resStats.getName().equalsIgnoreCase("MyGetDataOperation")) {
//                                        continue;
//                                    }
//
//                                    // Now get and print statistics for this resource
//                                    StatisticValue[] statValues = resStats.getStatistics();
//                                    for (StatisticValue value : statValues) {//success-rate
//                                        if (resourceType.toString().equalsIgnoreCase("SERVICE") && !value.getName().equalsIgnoreCase("response-time")) {
//                                            if (value.getName().equalsIgnoreCase("error-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                errorCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("message-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                msgCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("failure-rate")) {
//                                                StatisticValue.CountStatistic is3 = (StatisticValue.CountStatistic) value;
//                                                errorRatio = String.valueOf(is3.getCount());
//                                                //dataRow.createCell(collCtr).setCellValue(String.valueOf("" + errorRatio + "%"));
//                                                //collCtr++;
//                                                //
//                                                //r1c1 = row1.getCell(6);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                //r1c1.setCellValue(String.valueOf(String.valueOf("" + getRoundOfNumber(errorRatio) + "%")));
//                                            }
//                                            continue;
//                                        }
//
//                                        if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (value.getType() == StatisticType.INTERVAL) {
//                                            StatisticValue.IntervalStatistic is = (StatisticValue.IntervalStatistic) value;
//
//                                            //
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(msgCount));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(errorCount)));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMin()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMax()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getAverage()))));
//
//                                            System.out.println("" + proxyNameStr + " : " + is.getCount() + " : " + errorCount + " : " + String.valueOf(getFormatedTime(is.getMin())) + " : " + String.valueOf(getFormatedTime(is.getMax())) + " : " + String.valueOf(getFormatedTime(is.getAverage())));
//                                        }
//                                        msgCount = "";
//                                        errorCount = "";
//                                    }
//                                }
//                            } catch (MonitoringNotEnabledException mnee) {
//                                mnee.printStackTrace();
//                            } catch (InvalidServiceRefException isre) {
//                                isre.printStackTrace();
//                            } catch (MonitoringException me) {
//                                me.printStackTrace();
//                            }
//                        }
//                        icp1++;
//                    }
//                }
//            }
//        } catch (DomainMonitoringDisabledException f) {
//            f.printStackTrace();
//        } catch (MonitoringException f) {
//            f.printStackTrace();
//        }
//    }
//
//    public void getProxyServiceDetails_CustomerService(XSSFSheet sheet1, Properties prop, List filteredResourceNames, int rowCtr, int collCtr) {
//
//        String msgCount = "0";
//        String errorCount = "0";
//        String errorRatio = "0";
//        long varMin = 0;
//        long varMax = 0;
//        long varAvg = 0;
//
//        try {
//            proxyServiceRefs = serviceDomainMbean.getMonitoredProxyServiceRefs();
//
//            if (proxyServiceRefs != null && proxyServiceRefs.length != 0) {
//
//                int proxySize = Integer.parseInt(prop.getProperty("ServicePS"));
//                filteredProxyServiceRefs = new Ref[proxySize];
//                int ctrPS = 0;
//                for (int i = 0; i < proxyServiceRefs.length; i++) {
//                    //filteredProxyServiceRefs[i] = proxyServiceRefs[i];
//                    //System.out.println("proxyServiceRefs[i].getFullName()-->" + proxyServiceRefs[i].getFullName());
//                    //String serviceName = proxyServiceRefs[i].getFullName().substring(proxyServiceRefs[i].getFullName().lastIndexOf("/") + 1);
//
//
//                    for (int ictr = 0; ictr < proxySize; ictr++) {
//                        String fileTmp1 = prop.getProperty("ProxyService" + (ictr + 1));
//                        String fileWithPath1 = fileTmp1.substring(0, fileTmp1.lastIndexOf("@@"));
//                        //System.out.println("CCCCCCCCC-->" +ictr + "<-->" + fileTmp1);
//                        if (proxyServiceRefs[i].getFullName().equalsIgnoreCase(fileWithPath1)) {
//                            filteredProxyServiceRefs[ictr] = proxyServiceRefs[i];
//                            //System.out.println("MATCHED-->" +proxyServiceRefs[i].getFullName());
//                            ctrPS = ctrPS + 1;
//                        }
//                    }
//
//                }
//                System.out.println("=================================================");
//                System.out.println("PS Started...");
//                int icp1 = 0;
//                for (ResourceType resourceType : ResourceType.values()) {
//                    //System.out.println("ResourceType resourceType.....");
//                    if (icp1 == 0) {
//                        // Only process the following resource types: SERVICE,FLOW_COMPONENT,WEBSERVICE_OPERATION
//                        if (resourceType.name().equalsIgnoreCase("URI")) {
//                            continue;
//                        }
//                        HashMap proxyServiceResourceStatisticMap;
//                        proxyServiceResourceStatisticMap = serviceDomainMbean.getProxyServiceStatistics(filteredProxyServiceRefs, resourceType.value(), null);
//
//                        System.out.println("======= proxyServiceResourceStatisticMap.size(): " + proxyServiceResourceStatisticMap.size());
//
//                        Iterator it = proxyServiceResourceStatisticMap.entrySet().iterator();
//                        //out.write("\n=========================================");
//                        while (it.hasNext()) {
//                            System.out.println("proxyServiceResourceStatisticMap.entrySet().iterator().....");
//                            Map.Entry mapEntry = (Map.Entry) it.next();
//                            String proxyNameStr = String.valueOf(mapEntry.getKey());
//
//                            String serviceName = proxyNameStr.substring(proxyNameStr.lastIndexOf("/") + 1);
//                            proxyNameStr = proxyNameStr.substring(proxyNameStr.indexOf(" ") + 1, proxyNameStr.length());
//                            System.out.println("serviceName--------->" + serviceName);
//                            if (serviceName.contains("UpdateCustomerDetailsAGLProvABCSPSv1.1.0")) {
//                                System.out.println("serviceName--------->" + serviceName);
//                            }
//                            //
//                            String rowCtrVal = getRowCount(prop, "ServicePS", "ProxyService", proxyNameStr);
//                            rowCtr = Integer.parseInt(rowCtrVal);
//                            XSSFRow row1 = sheet1.getRow(rowCtr);
//                            XSSFCell r1c1 = null;
//
//                            collCtr = 1;
//
//                            //System.out.println("======= Printing statistics for service getKey: " + mapEntry.getKey() +" and resourceType: " + mapEntry.getValue() + " =======");
//
//                            ServiceResourceStatistic serviceStats = (ServiceResourceStatistic) mapEntry.getValue();
//
//                            try {
//                                ResourceStatistic[] resStatsArray = serviceStats.getAllResourceStatistics();
//
//                                for (ResourceStatistic resStats : resStatsArray) {
//
//                                    if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !filteredResourceNames.contains(resStats.getName())) {
//                                        continue;
//                                    }
//                                    if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !resStats.getName().equalsIgnoreCase("MyGetDataOperation")) {
//                                        continue;
//                                    }
//                                    int iCtr = 0;
//                                    // Now get and print statistics for this resource
//                                    StatisticValue[] statValues = resStats.getStatistics();
//                                    for (StatisticValue value : statValues) {//success-rate
//                                        String strValueGetName = value.getName();
//                                        //System.out.println("resourceType.toString()-->" + resourceType.toString() + " value.getName() -->" + value.getName());
//                                        if (resourceType.toString().equalsIgnoreCase("SERVICE") && !value.getName().equalsIgnoreCase("response-time")) {
//                                            if (strValueGetName.equalsIgnoreCase("error-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                errorCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (strValueGetName.equalsIgnoreCase("message-count")) {
//                                                StatisticValue.CountStatistic is2 = (StatisticValue.CountStatistic) value;
//                                                msgCount = String.valueOf(is2.getCount());
//                                            }
//                                            if (strValueGetName.equalsIgnoreCase("failure-rate")) {
//                                                StatisticValue.CountStatistic is3 = (StatisticValue.CountStatistic) value;
//                                                errorRatio = String.valueOf(is3.getCount());
//                                                //dataRow.createCell(collCtr).setCellValue(String.valueOf("" + errorRatio + "%"));
//                                                //collCtr++;
//                                                //
//                                                //r1c1 = row1.getCell(6);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                //r1c1.setCellValue(String.valueOf(String.valueOf("" + getRoundOfNumber(errorRatio) + "%")));
//                                            }
//                                            continue;
//                                        }
//
//                                        if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        iCtr = iCtr + 1;
//                                        //System.out.println("iCtr-->" + iCtr + " value.getType() -->" + value.getType());
//                                        if (value.getType() == StatisticType.INTERVAL) {
//                                            StatisticValue.IntervalStatistic is = (StatisticValue.IntervalStatistic) value;
//                                            varMin = is.getMin();
//                                            varMax = is.getMax();
//                                            varAvg = is.getAverage();
//                                        }
//                                        //msgCount = "";
//                                        //errorCount = "";
//                                    }
//                                    r1c1 = row1.getCell(collCtr);
//                                    //System.out.println("##r1c1 for PS  "+r1c1);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(msgCount));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(errorCount)));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varMin))));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varMax))));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varAvg))));
//
//                                    //**  //
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varMin)));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varMax)));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varAvg)));
//                                    //**  //
//                                    System.out.println("" + proxyNameStr + " : " + msgCount + " : " + errorCount + " : " + String.valueOf(varMin) + " : " + String.valueOf(varMax) + " : " + String.valueOf(varAvg));
//                                }
//                            } catch (MonitoringNotEnabledException mnee) {
//                                mnee.printStackTrace();
//                            } catch (InvalidServiceRefException isre) {
//                                isre.printStackTrace();
//                            } catch (MonitoringException me) {
//                                me.printStackTrace();
//                            }
//                        }
//                        icp1++;
//                    }
//                }
//            }
//        } catch (DomainMonitoringDisabledException f) {
//            f.printStackTrace();
//        } catch (MonitoringException f) {
//            f.printStackTrace();
//        }
//    }
//
//    public void getProxyServiceDetails(XSSFSheet sheet1, Properties prop, List filteredResourceNames, int rowCtr, int collCtr) {
//        String msgCount = "";
//        String errorCount = "";
//        String errorRatio = "";
//
//        try {
//            rowCtr = 0;
//            collCtr = 0;
//            proxyServiceRefs = serviceDomainMbean.getMonitoredProxyServiceRefs();
//
//            if (proxyServiceRefs != null && proxyServiceRefs.length != 0) {
//
//                int proxySize = Integer.parseInt(prop.getProperty("ServicePS"));
//                filteredProxyServiceRefs = new Ref[proxySize];
//                int ctrPS = 0;
//                for (int i = 0; i < proxyServiceRefs.length; i++) {
//                    //filteredProxyServiceRefs[i] = proxyServiceRefs[i];
//                    //System.out.println("proxyServiceRefs[i].getFullName()-->" + proxyServiceRefs[i].getFullName());
//                    //String serviceName = proxyServiceRefs[i].getFullName().substring(proxyServiceRefs[i].getFullName().lastIndexOf("/") + 1);
//
//                    for (int ictr = 0; ictr < proxySize; ictr++) {
//                        String fileTmp1 = prop.getProperty("ProxyService" + (ictr + 1));
//                        String fileWithPath1 = fileTmp1.substring(0, fileTmp1.lastIndexOf("@@"));
//                        //System.out.println("CCCCCCCCC-->" +ictr + "<-->" + fileTmp1);
//                        if (proxyServiceRefs[i].getFullName().equalsIgnoreCase(fileWithPath1)) {
//                            filteredProxyServiceRefs[ictr] = proxyServiceRefs[i];
//                            //System.out.println("MATCHED-->" +proxyServiceRefs[i].getFullName());
//                            ctrPS = ctrPS + 1;
//                        }
//                    }
//                }
//                System.out.println("=================================================");
//                System.out.println("PS Started...");
//                int icp1 = 0;
//                for (ResourceType resourceType : ResourceType.values()) {
//                    if (icp1 == 0) {
//                        // Only process the following resource types: SERVICE,FLOW_COMPONENT,WEBSERVICE_OPERATION
//                        if (resourceType.name().equalsIgnoreCase("URI")) {
//                            continue;
//                        }
//                        HashMap proxyServiceResourceStatisticMap;
//                        proxyServiceResourceStatisticMap = serviceDomainMbean.getProxyServiceStatistics(filteredProxyServiceRefs, resourceType.value(), null);
//
//                        System.out.println("======= proxyServiceResourceStatisticMap.size(): " + proxyServiceResourceStatisticMap.size());
//
//                        Iterator it = proxyServiceResourceStatisticMap.entrySet().iterator();
//                        //out.write("\n=========================================");
//                        while (it.hasNext()) {
//
//                            Map.Entry mapEntry = (Map.Entry) it.next();
//                            String proxyNameStr = String.valueOf(mapEntry.getKey());
//
//                            String serviceName = proxyNameStr.substring(proxyNameStr.lastIndexOf("/") + 1);
//                            proxyNameStr = proxyNameStr.substring(proxyNameStr.indexOf(" ") + 1, proxyNameStr.length());
//                            System.out.println("serviceName--------->" + serviceName);
//                            if (serviceName.contains("UpdateCustomerDetailsAGLProvABCSPSv1.1.0")) {
//                                System.out.println("serviceName--------->" + serviceName);
//                            }
//                            //
//                            String rowCtrVal = getRowCount(prop, "ServicePS", "ProxyService", proxyNameStr);
//                            rowCtr = Integer.parseInt(rowCtrVal);
//                            XSSFRow row1 = sheet1.getRow(rowCtr);
//                            XSSFCell r1c1 = null;
//
//                            collCtr = 1;
//
//                            //System.out.println("======= Printing statistics for service getKey: " + mapEntry.getKey() +" and resourceType: " + mapEntry.getValue() + " =======");
//
//                            ServiceResourceStatistic serviceStats = (ServiceResourceStatistic) mapEntry.getValue();
//
//                            try {
//                                ResourceStatistic[] resStatsArray = serviceStats.getAllResourceStatistics();
//
//                                for (ResourceStatistic resStats : resStatsArray) {
//
//                                    if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !filteredResourceNames.contains(resStats.getName())) {
//                                        continue;
//                                    }
//                                    if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !resStats.getName().equalsIgnoreCase("MyGetDataOperation")) {
//                                        continue;
//                                    }
//
//                                    // Now get and print statistics for this resource
//                                    StatisticValue[] statValues = resStats.getStatistics();
//                                    for (StatisticValue value : statValues) {//success-rate
//                                        if (resourceType.toString().equalsIgnoreCase("SERVICE") && !value.getName().equalsIgnoreCase("response-time")) {
//                                            if (value.getName().equalsIgnoreCase("error-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                errorCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("message-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                msgCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("failure-rate")) {
//                                                StatisticValue.CountStatistic is3 = (StatisticValue.CountStatistic) value;
//                                                errorRatio = String.valueOf(is3.getCount());
//                                                //dataRow.createCell(collCtr).setCellValue(String.valueOf("" + errorRatio + "%"));
//                                                //collCtr++;
//                                                //
//                                                //r1c1 = row1.getCell(6);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                //r1c1.setCellValue(String.valueOf(String.valueOf("" + getRoundOfNumber(errorRatio) + "%")));
//                                            }
//                                            continue;
//                                        }
//
//                                        if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (value.getType() == StatisticType.INTERVAL) {
//                                            StatisticValue.IntervalStatistic is = (StatisticValue.IntervalStatistic) value;
//
//                                            //
//                                            if (msgCount.equalsIgnoreCase("")) {
//                                                msgCount = String.valueOf(is.getCount());
//
//                                            }
//                                            r1c1 = row1.getCell(collCtr);
//                                            //System.out.println("##rlcl for PS "+r1c1);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(msgCount));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(errorCount)));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMin()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMax()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getAverage()))));
//
//                                            //**  //
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(is.getMin())));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(is.getMax())));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(is.getAverage())));
//                                            //**  //
//                                            System.out.println("" + proxyNameStr + " : " + is.getCount() + " : " + errorCount + " : " + String.valueOf(getFormatedTime(is.getMin())) + " : " + String.valueOf(getFormatedTime(is.getMax())) + " : " + String.valueOf(getFormatedTime(is.getAverage())));
//
//
//                                            if (rowCtr == 71) {
//                                                //
//                                                collCtr = 1;
//                                                rowCtr = 173;
//                                                XSSFRow row2 = sheet1.getRow(rowCtr);
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(msgCount));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(errorCount)));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMin()))));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMax()))));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getAverage()))));
//
//                                                // ** //
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(is.getMin())));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(is.getMax())));
//
//                                                collCtr = collCtr + 1;
//                                                r1c1 = row2.getCell(collCtr);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                r1c1.setCellValue(String.valueOf(String.valueOf(is.getAverage())));
//                                                // ** //
//                                            }
//
//                                        }
//                                        msgCount = "";
//                                        errorCount = "";
//                                    }
//                                }
//                            } catch (MonitoringNotEnabledException mnee) {
//                                mnee.printStackTrace();
//                            } catch (InvalidServiceRefException isre) {
//                                isre.printStackTrace();
//                            } catch (MonitoringException me) {
//                                me.printStackTrace();
//                            }
//                        }
//                        icp1++;
//                    }
//
//                }
//
//            }
//
//        } catch (DomainMonitoringDisabledException f) {
//            f.printStackTrace();
//        } catch (MonitoringException f) {
//            f.printStackTrace();
//        }
//    }
//
//    public void getBusinessServiceDetails(XSSFSheet sheet1, Properties prop, List filteredResourceNames, int rowCtr, int collCtr) {
//
//        String msgCount = "0";
//        String errorCount = "0";
//        String errorRatio = "0";
//        long varMin = 0;
//        long varMax = 0;
//        long varAvg = 0;
//        try {
//
//            businessServiceRefs = serviceDomainMbean.getMonitoredBusinessServiceRefs();
//
//            if (businessServiceRefs != null && businessServiceRefs.length != 0) {
//
//                int bisunessSize = Integer.parseInt(prop.getProperty("ServiceBS"));
//                filteredBusinessServiceRefs = new Ref[bisunessSize];
//                int ctrBS = 0;
//                for (int i = 0; i < businessServiceRefs.length; i++) {
//                    //filteredBusinessServiceRefs[i] = businessServiceRefs[i];
//                    //System.out.println("businessServiceRefs[i].getFullName()-->" + businessServiceRefs[i].getFullName());
//                    //String serviceName =  businessServiceRefs[i].getFullName().substring( businessServiceRefs[i].getFullName().lastIndexOf("/") + 1);
//
//                    for (int ictr = 0; ictr < bisunessSize; ictr++) {
//                        String fileTmp2 = prop.getProperty("BusinessService" + (ictr + 1));
//                        String fileWithPath2 = fileTmp2.substring(0, fileTmp2.lastIndexOf("@@"));
//                        if (businessServiceRefs[i].getFullName().equalsIgnoreCase(fileWithPath2)) {
//                            filteredBusinessServiceRefs[ictr] = businessServiceRefs[i];
//                            //System.out.println("MATCHED-->" +businessServiceRefs[i].getFullName());
//                            ctrBS = ctrBS + 1;
//                        }
//                    }
//
//                }
//
//                System.out.println("=================================================");
//                System.out.println("BS Started...");
//                int icp1 = 0;
//                for (ResourceType resourceType : ResourceType.values()) {
//                    if (icp1 == 0) {
//                        // Only process the following resource types: SERVICE,FLOW_COMPONENT,WEBSERVICE_OPERATION
//                        if (resourceType.name().equalsIgnoreCase("URI")) {
//                            continue;
//                        }
//                        HashMap businessServiceResourceStatisticMap;
//                        businessServiceResourceStatisticMap = serviceDomainMbean.getBusinessServiceStatistics(filteredBusinessServiceRefs, resourceType.value(), null);
//
//                        System.out.println("======= businessServiceResourceStatisticMap.size(): " + businessServiceResourceStatisticMap.size());
//
//                        Iterator it = businessServiceResourceStatisticMap.entrySet().iterator();
//                        //out.write("\n=========================================");
//                        while (it.hasNext()) {
//
//                            Map.Entry mapEntry = (Map.Entry) it.next();
//                            String businessNameStr = String.valueOf(mapEntry.getKey());
//
//
//                            businessNameStr = businessNameStr.substring(businessNameStr.indexOf(" ") + 1, businessNameStr.length());
//                            String serviceName = businessNameStr.substring(businessNameStr.lastIndexOf("/") + 1);
//                            //System.out.println("BusinessserviceName...1111-->" + serviceName);
//                            if (serviceName.contains("NPC_OutboundBS")) {
//                                System.out.println("serviceName--------->" + serviceName);
//                            }
//                            //
//                            String rowCtrVal = getRowCount(prop, "ServiceBS", "BusinessService", businessNameStr);
//                            //System.out.println("serviceName--------->" + serviceName);
//                            rowCtr = Integer.parseInt(rowCtrVal);
//                            XSSFRow row1 = sheet1.getRow(rowCtr);
//                            XSSFCell r1c1 = null;
//
//                            collCtr = 1;
//
//                            //System.out.println("======= Printing statistics for service getKey: " + mapEntry.getKey() + " and resourceType: " + mapEntry.getValue() + " =======");
//
//                            ServiceResourceStatistic serviceStats = (ServiceResourceStatistic) mapEntry.getValue();
//
//                            try {
//                                ResourceStatistic[] resStatsArray = serviceStats.getAllResourceStatistics();
//
//                                for (ResourceStatistic resStats : resStatsArray) {
//
//                                    if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !filteredResourceNames.contains(resStats.getName())) {
//                                        continue;
//                                    }
//                                    if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !resStats.getName().equalsIgnoreCase("MyGetDataOperation")) {
//                                        continue;
//                                    }
//                                    int iCtr = 0;
//
//                                    // Now get and print statistics for this resource
//                                    StatisticValue[] statValues = resStats.getStatistics();
//                                    for (StatisticValue value : statValues) {//success-rate
//                                        if (resourceType.toString().equalsIgnoreCase("SERVICE") && !value.getName().equalsIgnoreCase("response-time")) {
//                                            if (value.getName().equalsIgnoreCase("error-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                errorCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("message-count")) {
//                                                StatisticValue.CountStatistic is2 = (StatisticValue.CountStatistic) value;
//                                                msgCount = String.valueOf(is2.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("failure-rate")) {
//                                                StatisticValue.CountStatistic is3 = (StatisticValue.CountStatistic) value;
//                                                errorRatio = String.valueOf(is3.getCount());
//                                                //
//                                                //r1c1 = row1.getCell(6);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                //r1c1.setCellValue(String.valueOf(String.valueOf("" + getRoundOfNumber(errorRatio) + "%")));
//                                            }
//                                            continue;
//                                        }
//
//                                        if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        iCtr = iCtr + 1;
//                                        if (value.getType() == StatisticType.INTERVAL) {
//                                            StatisticValue.IntervalStatistic is = (StatisticValue.IntervalStatistic) value;
//                                            varMin = is.getMin();
//                                            varMax = is.getMax();
//                                            varAvg = is.getAverage();
//                                        }
//                                    }
//                                    //
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(msgCount));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf((String.valueOf(errorCount))));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varMin))));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varMax))));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(varAvg))));
//
//                                    //** //
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varMin)));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varMax)));
//
//                                    collCtr = collCtr + 1;
//                                    r1c1 = row1.getCell(collCtr);
//                                    //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                    r1c1.setCellValue(String.valueOf(String.valueOf(varAvg)));
//                                    //** //
//                                    System.out.println("" + businessNameStr + " : " + msgCount + " : " + errorCount + " : " + String.valueOf(varMin) + " : " + String.valueOf(varMax) + " : " + String.valueOf(varAvg));
//
//                                                /*
//                                                                                                                                                                                      System.out.println("" + businessNameStr + " : " +is.getCount() + " : " + errorCount + " : " + String.valueOf(getFormatedTime(is.getMin()))
//                                                                   + " : " + String.valueOf(getFormatedTime(is.getMax())) + " : " + String.valueOf(getFormatedTime(is.getAverage())));
//
//                                            //}
//                                            //msgCount = "";
//                                            //errorCount = "";*/
//
//
//                                }
//
//
//                            } catch (MonitoringNotEnabledException mnee) {
//                                mnee.printStackTrace();
//                                // Statistics not available
//                                //out.write("\nWARNING: Monitoring is not enabled for this service... Do something...");
//                                //out.write("\n=====================================");
//
//                            } catch (InvalidServiceRefException isre) {
//                                isre.printStackTrace();
//                                // Invalid service
//                                //out.write("\nERROR: Invlaid Ref. May be this service is deleted. Do something...");
//                                //out.write("\n======================================");
//                            } catch (MonitoringException me) {
//                                // Statistics not available
//                                //out.write("\nERROR: Failed to get statistics for this service...Details: " +me.getMessage());
//                                me.printStackTrace();
//                                //out.write("\n======================================");
//                            }
//                        }
//                        icp1++;
//                    }
//
//                }
//            }
//
//        } catch (DomainMonitoringDisabledException f) {
//            f.printStackTrace();
//        } catch (MonitoringException f) {
//            f.printStackTrace();
//        }
//    }
//
//    public void getBusinessServiceDetails_ESFRealTime1ServiceHealth(XSSFSheet sheet1, Properties prop, List filteredResourceNames, int rowCtr, int collCtr) {
//
//        String msgCount = "0";
//        String errorCount = "0";
//        String errorRatio = "0";
//        try {
//
//            businessServiceRefs = serviceDomainMbean.getMonitoredBusinessServiceRefs();
//
//            if (businessServiceRefs != null && businessServiceRefs.length != 0) {
//
//                int bisunessSize = Integer.parseInt(prop.getProperty("ServiceBS"));
//                filteredBusinessServiceRefs = new Ref[bisunessSize];
//                for (int i = 0; i < businessServiceRefs.length; i++) {
//                    //filteredBusinessServiceRefs[i] = businessServiceRefs[i];
//                    //System.out.println("businessServiceRefs[i].getFullName()-->" + businessServiceRefs[i].getFullName());
//                    //String serviceName =  businessServiceRefs[i].getFullName().substring( businessServiceRefs[i].getFullName().lastIndexOf("/") + 1);
//
//                    for (int ictr = 0; ictr < bisunessSize; ictr++) {
//                        String fileTmp2 = prop.getProperty("BusinessService" + (ictr + 1));
//                        String fileWithPath2 = fileTmp2.substring(0, fileTmp2.lastIndexOf("@@"));
//                        if (businessServiceRefs[i].getFullName().equalsIgnoreCase(fileWithPath2)) {
//                            filteredBusinessServiceRefs[ictr] = businessServiceRefs[i];
//                            //System.out.println("MATCHED-->" +businessServiceRefs[i].getFullName());
//                        }
//                    }
//
//                }
//
//                System.out.println("=================================================");
//                System.out.println("BS Started...");
//                int icp1 = 0;
//                for (ResourceType resourceType : ResourceType.values()) {
//                    if (icp1 == 0) {
//                        // Only process the following resource types: SERVICE,FLOW_COMPONENT,WEBSERVICE_OPERATION
//                        if (resourceType.name().equalsIgnoreCase("URI")) {
//                            continue;
//                        }
//                        HashMap businessServiceResourceStatisticMap;
//                        try {
//
//                        } catch (Exception e) {
//                            System.out.print("ERROR-->" + e.getMessage());
//                            // Statistics not available
//                            //out.write("\nWARNING: Monitoring is not enabled for this service... Do something...");
//                            //out.write("\n=====================================");
//
//                        }
//                        businessServiceResourceStatisticMap = serviceDomainMbean.getBusinessServiceStatistics(filteredBusinessServiceRefs, resourceType.value(), null);
//
//                        System.out.println("======= businessServiceResourceStatisticMap.size(): " + businessServiceResourceStatisticMap.size());
//
//                        Iterator it = businessServiceResourceStatisticMap.entrySet().iterator();
//                        //out.write("\n=========================================");
//                        while (it.hasNext()) {
//
//                            Map.Entry mapEntry = (Map.Entry) it.next();
//                            String businessNameStr = String.valueOf(mapEntry.getKey());
//
//
//                            businessNameStr = businessNameStr.substring(businessNameStr.indexOf(" ") + 1, businessNameStr.length());
//                            String serviceName = businessNameStr.substring(businessNameStr.lastIndexOf("/") + 1);
//                            //System.out.println("BusinessserviceName...1111-->" + serviceName);
//                            //if(serviceName.contains("NPC_OutboundBS")){
//                            //    System.out.println("serviceName--------->" + serviceName);
//                            //}
//                            //
//                            String rowCtrVal = getRowCount(prop, "ServiceBS", "BusinessService", businessNameStr);
//                            //System.out.println("serviceName--------->" + serviceName);
//                            rowCtr = Integer.parseInt(rowCtrVal);
//                            XSSFRow row1 = sheet1.getRow(rowCtr);
//                            XSSFCell r1c1 = null;
//
//                            collCtr = 1;
//
//                            //System.out.println("======= Printing statistics for service getKey: " + mapEntry.getKey() + " and resourceType: " + mapEntry.getValue() + " =======");
//
//                            ServiceResourceStatistic serviceStats = (ServiceResourceStatistic) mapEntry.getValue();
//
//                            try {
//                                ResourceStatistic[] resStatsArray = serviceStats.getAllResourceStatistics();
//
//                                for (ResourceStatistic resStats : resStatsArray) {
//
//                                    if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !filteredResourceNames.contains(resStats.getName())) {
//                                        continue;
//                                    }
//                                    if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !resStats.getName().equalsIgnoreCase("MyGetDataOperation")) {
//                                        continue;
//                                    }
//
//                                    // Now get and print statistics for this resource
//                                    StatisticValue[] statValues = resStats.getStatistics();
//                                    for (StatisticValue value : statValues) {//success-rate
//                                        if (resourceType.toString().equalsIgnoreCase("SERVICE") && !value.getName().equalsIgnoreCase("response-time")) {
//                                            if (value.getName().equalsIgnoreCase("error-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                errorCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("message-count")) {
//                                                StatisticValue.CountStatistic is1 = (StatisticValue.CountStatistic) value;
//                                                msgCount = String.valueOf(is1.getCount());
//                                            }
//                                            if (value.getName().equalsIgnoreCase("failure-rate")) {
//                                                StatisticValue.CountStatistic is3 = (StatisticValue.CountStatistic) value;
//                                                errorRatio = String.valueOf(is3.getCount());
//                                                //
//                                                //r1c1 = row1.getCell(6);
//                                                //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                                //r1c1.setCellValue(String.valueOf(String.valueOf("" + getRoundOfNumber(errorRatio) + "%")));
//                                            }
//                                            continue;
//                                        }
//
//                                        if (resourceType.toString().equalsIgnoreCase("FLOW_COMPONENT") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (resourceType.toString().equalsIgnoreCase("WEBSERVICE_OPERATION") && !value.getType().toString().equalsIgnoreCase("INTERVAL")) {
//                                            continue;
//                                        }
//                                        if (value.getType() == StatisticType.INTERVAL) {
//                                            StatisticValue.IntervalStatistic is = (StatisticValue.IntervalStatistic) value;
//
//                                            //
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(msgCount));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue((String.valueOf(errorCount)));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMin()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getMax()))));
//
//                                            collCtr = collCtr + 1;
//                                            r1c1 = row1.getCell(collCtr);
//                                            //r1c1.setCellType(Cell.CELL_TYPE_STRING);
//                                            r1c1.setCellValue(String.valueOf(String.valueOf(getFormatedTime(is.getAverage()))));
//
//                                            System.out.println("" + businessNameStr + " : " + is.getCount() + " : " + errorCount + " : " + String.valueOf(getFormatedTime(is.getMin())) + " : " + String.valueOf(getFormatedTime(is.getMax())) + " : " + String.valueOf(getFormatedTime(is.getAverage())));
//
//                                        }
//                                        msgCount = "";
//                                        errorCount = "";
//                                    }
//
//                                }
//
//
//                            } catch (MonitoringNotEnabledException mnee) {
//                                mnee.printStackTrace();
//                                // Statistics not available
//                                //out.write("\nWARNING: Monitoring is not enabled for this service... Do something...");
//                                //out.write("\n=====================================");
//
//                            } catch (InvalidServiceRefException isre) {
//                                isre.printStackTrace();
//                                // Invalid service
//                                //out.write("\nERROR: Invlaid Ref. May be this service is deleted. Do something...");
//                                //out.write("\n======================================");
//                            } catch (MonitoringException me) {
//                                // Statistics not available
//                                //out.write("\nERROR: Failed to get statistics for this service...Details: " +me.getMessage());
//                                me.printStackTrace();
//                                //out.write("\n======================================");
//                            }
//                        }
//                        icp1++;
//                    }
//
//                }
//            }
//
//        } catch (DomainMonitoringDisabledException f) {
//            f.printStackTrace();
//        } catch (MonitoringException f) {
//            f.printStackTrace();
//        }
//    }
//
//    public String getFormatedTime(long millis) {
//
//        String returnVal = "";
//        try {
//
//            long second = (millis / 1000) % 60;
//            long minute = (millis / (1000 * 60)) % 60;
//            long hour = (millis / (1000 * 60 * 60)) % 24;
//
//            long temp = hour * 3600000;
//            temp = millis - temp;
//            //System.out.println(" 111 " + temp );
//            temp = temp - (minute * 60000);
//            //System.out.println(" 111 " + temp );
//            temp = temp - (second * 1000);
//            //System.out.println(" 111 " + temp );
//
//            if (hour != 0) {
//                returnVal = hour + " hour ";
//            }
//            if (minute != 0) {
//                returnVal = returnVal + minute + " mins ";
//            }
//            if (second != 0) {
//                returnVal = returnVal + second + " secs ";
//            }
//            if (temp != 0) {
//                returnVal = returnVal + temp + " msecs ";
//            }
//            //System.out.println(hour + " hours " + mins + " mins " + second + " secs " + temp + " msecs" );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return returnVal;
//    }
//
//    public static void refreshExcelFormulaCells(String Excel_File_Path) throws Exception {
//
//        FileInputStream inputFile = new FileInputStream(new File(Excel_File_Path)); //  XLS file
//        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputFile); //create a blank workbook object
//        inputFile.close();
//
//        evaluateAllFormulaCells(newWorkbook);
//        FileOutputStream outputFile = new FileOutputStream(new File(Excel_File_Path)); //create XLS file
//        newWorkbook.write(outputFile); //write excel document to output stream
//        outputFile.close(); //close the file
//    }
//
//    public static void evaluateAllFormulaCells(XSSFWorkbook wb) {
//        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(wb);
//        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//            Sheet sheet = wb.getSheetAt(i);
//            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext(); ) {
//                Row r = rit.next();
//                for (Iterator cit = r.cellIterator(); cit.hasNext(); ) {
//                    XSSFCell c = (XSSFCell) cit.next();
//                    if (c.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
//                        //System.out.print("FORMULAS-->" + c.toString());
//                        evaluator.evaluateFormulaCell(c);
//                    }
//                }
//            }
//        }
//        System.out.print("FORMULAS5-->");
//    }
//
//    public String getRoundOfNumber(String num) {
//        String str = "0.00";
//        if ((null != num) && !(num.equalsIgnoreCase(""))) {
//            double dd = Double.parseDouble(num);
//
//            DecimalFormat f = new DecimalFormat("##.00");
//            str = f.format(dd);
//        } else {
//            return str;
//
//        }
//        if (str.equalsIgnoreCase(".00")) str = "0.00";
//        return str;
//    }
//
//    public static void main(String[] args) {
//
//        ServiceStatisticsReport myProxyServiceStatisticsRetriever = new ServiceStatisticsReport();
//    }
//
//    public String getRowCount(Properties propVar, String tmpVar, String tmpVar2, String findVar) {
//        String returnVal = "";
//        int proxySize1 = Integer.parseInt(propVar.getProperty(tmpVar));
//        //System.out.println("#size of temp var  "+proxySize1);
//        for (int ictr = 0; ictr < proxySize1; ictr++) {
//            String fileTmp = propVar.getProperty(tmpVar2 + (ictr + 1));
//            String fileWithPath = fileTmp.substring(0, fileTmp.lastIndexOf("@@"));
//            String fileName = fileWithPath;
//            if (fileWithPath.contains("/")) {
//                fileName = fileWithPath.substring(fileWithPath.lastIndexOf("/") + 1, fileWithPath.length());
//            }
//            //System.out.println("55555---->" + fileName );
//            String rowCount = fileTmp.substring(fileTmp.lastIndexOf("@@") + 2, fileTmp.length());
//            if (findVar.equalsIgnoreCase(fileWithPath)) {
//                return rowCount;
//            }
//            //System.out.println("##rowCount  "+rowCount);
//        }
//        //System.out.println("##returnVal  "+returnVal);
//        return returnVal;
//
//    }
//}