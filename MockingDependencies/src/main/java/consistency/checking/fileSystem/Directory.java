package consistency.checking.fileSystem;


import consistency.checking.contracts.IDataUnit;

public class Directory extends FileSystemUnit implements IDataUnit<FileSystemUnit[]> {

	FileSystemUnit[] units=null;
	String filePath;
	
	public Directory(String filePath,FileSystemUnit[] unit) {
		super(FileSystemUnitType.Directory);
	}
	
	@Override
	public String getKey() {
		return filePath;
	}

	@Override
	public FileSystemUnit[] getValue() {
		return units;
	}

	@Override
	public void setValue(FileSystemUnit[] value) {

	}
}
