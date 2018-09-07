package sberoad.generators;


import java.io.IOException;


public class AutoAllure {

    public void autoReport() throws IOException {
        try {
//            Process proc = Runtime.getRuntime().exec("cmd /c allure generate --clean");
//            Process proc = Runtime.getRuntime().exec("C:\\Users\\BChertok\\Documents\\Tools\\allure-2.7.0\\allure-2.7.0\\bin\\allure.bat generate --clean");
            Process proc = Runtime.getRuntime().exec("allure.bat generate --clean");
            proc.waitFor();
            Runtime.getRuntime().exec("allure.bat open");
            proc.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}

