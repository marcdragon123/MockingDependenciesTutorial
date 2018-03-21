package consistency.checking;

import consistency.checking.contracts.IDataUnit;
import consistency.checking.fileSystem.Directory;
import consistency.checking.fileSystem.File;
import consistency.checking.fileSystem.FileSystemUnit;
import consistency.checking.main.FileSystemHashGenerator;

public class FileSystemIntegrityUnit implements IDataUnit<String> {

	String path;
	private String integrityValue;
	public FileSystemIntegrityUnit(FileSystemUnit unit,FileSystemHashGenerator hashGenerator) {
		
		this.path=unit.getPath();
		integrityValue=hashGenerator.hash(unit);	
	}

	@Override
	public String getKey() {
		return path;
	}

	@Override
	public String getValue() {
		return integrityValue;
	}

	@Override
	public void setValue(String value) {
	}

}
