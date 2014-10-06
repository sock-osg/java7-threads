/*
 * FileSearch.java
 */
package com.oz.java7.threads.ch1.utils;

import java.io.File;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 5:18:22 PM
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    /**
     * @param initPath
     * @param fileName
     */
    public FileSearch(String initPath, String fileName) {
        super();
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(this.initPath);

        if (file.isDirectory()) {
            try {
                this.directoryProcess(file);
            } catch (InterruptedException intExc) {
                System.out.printf("%s: The search has been interupted", Thread.currentThread().getName());
            }
        }
    }

    /**
     * @param file
     * @throws InterruptedException
     */
    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();

        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    this.directoryProcess(list[i]);
                } else {
                    this.fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * @param file
     * @throws InterruptedException
     */
    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(this.fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsoluteFile());
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

}
