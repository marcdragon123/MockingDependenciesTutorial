package consistency.checking.fileSystem;

import consistency.checking.InMemoryFileSystemIntegrityDataStore;
import consistency.checking.contracts.IConsistencyChecker;
import consistency.checking.contracts.INotifier;
import consistency.checking.main.FileSystemHashGenerator;

public class FileConsistencyChecker implements IConsistencyChecker {


	private INotifier notifier;
	private InMemoryFileSystemIntegrityDataStore integrityStore;
	private FileSystemDataStore fileStore;
	private FileSystemHashGenerator hashGenerator;

	public FileConsistencyChecker(INotifier notifer,
			InMemoryFileSystemIntegrityDataStore integrityStore, // for each file/directory holds the corresponding hash value
			FileSystemDataStore fileStore, // contains all the files and directories
			FileSystemHashGenerator hashGenerator // helps you to compute the hash of files/directories
			) {
		
		this.notifier=notifer;
		this.integrityStore=integrityStore;
		this.fileStore=fileStore;
		this.hashGenerator=hashGenerator;
		
	}

	/*
	 * 
	 * 
	 */
	@Override
	public void checkConsistency() {

		// TODO
		// 1. iterate over items in fileStore and compute the checksum of files/directories
		// check whether the computed checksum is equal to the previously computed checksum
		// 2. in case of checksum violation, use notifier to print the error
		
	}
	
}
