package consistency.checking;

import consistency.checking.contracts.IDataUnit;
import consistency.checking.fileSystem.Directory;
import consistency.checking.fileSystem.File;
import consistency.checking.fileSystem.FileSystemUnit;
import consistency.checking.main.FileSystemHashGenerator;

public class FileSystemIntegrityUnit implements IDataUnit<String> {

	String path;
	private String integrityValue;
	private FileSystemHashGenerator hashGenerator;
	
	public FileSystemIntegrityUnit(FileSystemUnit unit,FileSystemHashGenerator hashGenerator) {
		
		this.hashGenerator=hashGenerator;
		if(unit instanceof File) {
			this.path=((File)unit).getKey();
			integrityValue=hashGenerator.hash(unit);
		}
			
		else {
			this.path=((Directory)unit).getKey();
			integrityValue=hashGenerator.hash(unit);
		}
			
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
