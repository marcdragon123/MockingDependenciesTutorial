package consistency.checking.main;

import consistency.checking.contracts.IHashGenerator;
import consistency.checking.fileSystem.Directory;
import consistency.checking.fileSystem.File;
import consistency.checking.fileSystem.FileSystemUnit;

public class FileSystemHashGenerator implements IHashGenerator<FileSystemUnit>{

	@Override
	public String hash(FileSystemUnit unit) {

		if(unit instanceof File)
			return ComputeHash((File)unit);
		else
			return ComputeHash((Directory)unit);
	}

	private String ComputeHash(Directory unit) {
		return null;
	}

	private String ComputeHash(File unit) {
		return null;
	}

}
