package consistency.checking.main;

import consistency.checking.FileSystemIntegrityUnit;
import consistency.checking.InMemoryFileSystemIntegrityDataStore;
import consistency.checking.fileSystem.FileConsistencyChecker;
import consistency.checking.fileSystem.FileSystemDataStore;
import consistency.checking.fileSystem.FileSystemUnit;

public class Main {

	public static void main(String[] args) {

		InMemoryFileSystemIntegrityDataStore integrityStore= new InMemoryFileSystemIntegrityDataStore();
		
		InitIntegrityStore(integrityStore);
		CheckIntegrity(integrityStore);
	}

	private static void InitIntegrityStore(InMemoryFileSystemIntegrityDataStore integrityStore) {
	
		FileSystemDataStore fileStore=new FileSystemDataStore("path");
		
		for(FileSystemUnit unit:fileStore) {
			integrityStore.store(new FileSystemIntegrityUnit(unit, new FileSystemHashGenerator()));	
		}
	}

	private static void CheckIntegrity(InMemoryFileSystemIntegrityDataStore integrityStore) {

		while(true) {
		
			FileSystemDataStore fileStore=new FileSystemDataStore("path");
			FileConsistencyChecker consistencyChecker = new FileConsistencyChecker(null,integrityStore,fileStore);
			consistencyChecker.checkConsistency();
		}
		
		
	}


}
