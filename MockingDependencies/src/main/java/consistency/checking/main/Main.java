package consistency.checking.main;

import java.util.concurrent.TimeUnit;

import consistency.checking.FileSystemIntegrityUnit;
import consistency.checking.InMemoryFileSystemChecksumDataStore;
import consistency.checking.contracts.IHashGenerator;
import consistency.checking.contracts.INotifier;
import consistency.checking.fileSystem.FileConsistencyChecker;
import consistency.checking.fileSystem.FileSystemDataStore;
import consistency.checking.fileSystem.FileSystemUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		String userFolderPath="UserFiles";
		InMemoryFileSystemChecksumDataStore checksumStore= new InMemoryFileSystemChecksumDataStore();
		
		InitIntegrityStore(checksumStore,userFolderPath); // at first we compute the correct checksum for all files and folders
		CheckIntegrity(checksumStore,userFolderPath); // we will constantly check the correctness of files
	}

	private static void InitIntegrityStore(InMemoryFileSystemChecksumDataStore checksumStore,String path) {
	
		FileSystemDataStore fileStore=new FileSystemDataStore(path);
		
		for(FileSystemUnit unit:fileStore) {
			checksumStore.store(new FileSystemIntegrityUnit(unit, new FileSystemHashGenerator()));	
		}
	}

	private static void CheckIntegrity(InMemoryFileSystemChecksumDataStore checksumStore,String path) throws InterruptedException {

		INotifier notifier= new ConsoleNotifier();
		FileSystemHashGenerator hashGenerator= new FileSystemHashGenerator();
		
		// This part should get run by a thread. It's here just for simplicity
		while(true) {
		
			FileSystemDataStore fileStore=new FileSystemDataStore(path);
			FileConsistencyChecker consistencyChecker = new FileConsistencyChecker(notifier,checksumStore,fileStore,hashGenerator);
			consistencyChecker.checkConsistency();
			TimeUnit.SECONDS.sleep(1);
		}
		
		
	}


}
