package consistency.checking.fileSystem;

import com.google.common.io.ByteSource;

import consistency.checking.contracts.IDataUnit;

public class File extends FileSystemUnit implements IDataUnit<ByteSource> {

	ByteSource content=null;
	String filePath;
	Directory owner;
	
	public File(String filePath,ByteSource content) {
		super(FileSystemUnitType.File);
		this.filePath=filePath;
		this.content=content;

	}
	
	@Override
	public String getKey() {
		return this.filePath;
	}

	@Override
	public ByteSource getValue() {
		return content;
	}

	@Override
	public void setValue(ByteSource value) {
		
	}

	
	
}
