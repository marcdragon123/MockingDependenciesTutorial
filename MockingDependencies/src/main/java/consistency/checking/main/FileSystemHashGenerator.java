package consistency.checking.main;

import java.io.IOException;

import com.google.common.hash.Hashing;

import consistency.checking.contracts.IHashGenerator;
import consistency.checking.fileSystem.Directory;
import consistency.checking.fileSystem.File;
import consistency.checking.fileSystem.FileSystemUnit;

public class FileSystemHashGenerator implements IHashGenerator<FileSystemUnit>{

	/*
	 * unit: can be a file or directory
	 * returns the unique checksum of the unit
	 */
	@Override
	public String hash(FileSystemUnit unit) {

		if(unit instanceof File)
			return ComputeHash((File)unit);
		else
			return ComputeHash((Directory)unit);
	}

	private String ComputeHash(Directory directory) {
		
		String checksum ="";
		
		for(FileSystemUnit unit: directory.getValue()) {
			
			if(unit instanceof File) {
				checksum   += ComputeHash((File)unit);	
			}
		}
		
		return checksum;
		
	}

	private String ComputeHash(File file) {
		
			try {
				return file.getValue().hash(Hashing.sha256()).toString();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
			return null;
			
	}

}
