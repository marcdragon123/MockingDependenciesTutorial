package consistency.checking.main;

import java.util.concurrent.TimeUnit;

import consistency.checking.FileSystemIntegrityUnit;
import consistency.checking.InMemoryFileSystemIntegrityDataStore;
import consistency.checking.contracts.IHashGenerator;
import consistency.checking.contracts.INotifier;
import consistency.checking.fileSystem.FileConsistencyChecker;
import consistency.checking.fileSystem.FileSystemDataStore;
import consistency.checking.fileSystem.FileSystemUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		String userFolderPath="UserFiles";
		InMemoryFileSystemIntegrityDataStore integrityStore= new InMemoryFileSystemIntegrityDataStore();
		
		InitIntegrityStore(integrityStore,userFolderPath); // at first we compute the correct checksum for all files and folders
		CheckIntegrity(integrityStore,userFolderPath); // we will constantly check the correctness of files
	}

	private static void InitIntegrityStore(InMemoryFileSystemIntegrityDataStore integrityStore,String path) {
	
		FileSystemDataStore fileStore=new FileSystemDataStore(path);
		
		for(FileSystemUnit unit:fileStore) {
			integrityStore.store(new FileSystemIntegrityUnit(unit, new FileSystemHashGenerator()));	
		}
	}

	private static void CheckIntegrity(InMemoryFileSystemIntegrityDataStore integrityStore,String path) throws InterruptedException {

		INotifier notifier= new ConsoleNotifier();
		FileSystemHashGenerator hashGenerator= new FileSystemHashGenerator();
		
		// This part should get run by a thread. It's here just for simplicity
		while(true) {
		
			FileSystemDataStore fileStore=new FileSystemDataStore(path);
			FileConsistencyChecker consistencyChecker = new FileConsistencyChecker(notifier,integrityStore,fileStore,hashGenerator);
			consistencyChecker.checkConsistency();
			TimeUnit.SECONDS.sleep(1);
		}
		
		
	}


}
