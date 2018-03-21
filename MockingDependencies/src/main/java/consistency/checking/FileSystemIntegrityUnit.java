package consistency.checking;

import consistency.checking.contracts.IDataUnit;
import consistency.checking.fileSystem.Directory;
import consistency.checking.fileSystem.File;
import consistency.checking.fileSystem.FileSystemUnit;
import consistency.checking.main.FileSystemHashGenerator;

public class FileSystemIntegrityUnit implements IDataUnit<String> {

	String filePath;
	private String integrityValue;
	private FileSystemHashGenerator hashGenerator;
	
	public FileSystemIntegrityUnit(FileSystemUnit unit,FileSystemHashGenerator hashGenerator) {
		
		this.hashGenerator=hashGenerator;
		if(unit instanceof File)
			integrityValue=ComputeIntegrityValue((File)unit);
		else
			integrityValue=ComputeIntegrityValue((Directory)unit);
	}
	
	private String ComputeIntegrityValue(File file) {
		return hashGenerator.hash(file);
	}
	
	private String ComputeIntegrityValue(Directory directory) {
		return hashGenerator.hash(directory);
	}

	@Override
	public String getKey() {
		return filePath;
	}

	@Override
	public String getValue() {
		return integrityValue;
	}

	@Override
	public void setValue(String value) {
	}

}
