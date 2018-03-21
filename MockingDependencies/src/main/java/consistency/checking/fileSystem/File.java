package consistency.checking.fileSystem;

import consistency.checking.contracts.IDataUnit;

public class File extends FileSystemUnit implements IDataUnit<byte[]> {

	byte[] content=null;
	String filePath;
	Directory owner;
	
	public File(String filePath,byte[] content) {
		super(FileSystemUnitType.File);
		this.filePath=filePath;
		this.content=content;
		
	}
	
	@Override
	public String getKey() {
		return this.filePath;
	}

	@Override
	public byte[] getValue() {
		return content;
	}

	@Override
	public void setValue(byte[] value) {
		
	}

	
	
}
