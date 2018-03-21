package consistency.checking.fileSystem;


import consistency.checking.contracts.IDataUnit;

public class Directory extends FileSystemUnit implements IDataUnit<FileSystemUnit[]> {

	FileSystemUnit[] units=null;
	String directoryPath;
	
	public Directory(String directoryPath,FileSystemUnit[] units) {
		super(FileSystemUnitType.Directory);
		this.units=units;
		this.directoryPath=directoryPath;
	}
	
	public Directory(String directoryPath) {
		super(FileSystemUnitType.Directory);
		this.directoryPath=directoryPath;
	}
	
	
	@Override
	public String getKey() {
		return directoryPath;
	}

	@Override
	public FileSystemUnit[] getValue() {
		return units;
	}

	@Override
	public void setValue(FileSystemUnit[] units) {
		this.units=units;
	}
}
