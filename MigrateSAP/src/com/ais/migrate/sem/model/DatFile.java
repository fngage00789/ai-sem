package com.ais.migrate.sem.model;

import java.io.File;
import java.io.Serializable;

public class DatFile implements Serializable{
	
	private String fileName;
	private File file;
	private SyncFile syncFile;
	
	public DatFile(String fileName, File file) {
		this.fileName = fileName;
		this.file = file;
	}
	public DatFile(String fileName, File file, SyncFile syncFile) {
		this.fileName = fileName;
		this.file = file;
		this.syncFile = syncFile;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public File getFile() {
		return file;
	}
	public void setSyncFile(SyncFile syncFile) {
		this.syncFile = syncFile;
	}
	public SyncFile getSyncFile() {
		return syncFile;
	}
	
}
