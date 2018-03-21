package consistency.checking.main;

import consistency.checking.InMemoryIntegrityDataStore;
import consistency.checking.FileSystemIntegrityUnit;
import consistency.checking.fileSystem.FileConsistencyChecker;
import consistency.checking.fileSystem.FileSystemDataStore;
import consistency.checking.fileSystem.FileSystemUnit;

public class Main {

	public static void main(String[] args) {

		InMemoryIntegrityDataStore integrityStore= new InMemoryIntegrityDataStore();
		
		InitIntegrityStore(integrityStore);
		CheckIntegrity(integrityStore);
	}

	private static void InitIntegrityStore(InMemoryIntegrityDataStore integrityStore) {
	
		FileSystemDataStore fileStore=new FileSystemDataStore("path");
		
		for(FileSystemUnit unit:fileStore) {
			integrityStore.store(new FileSystemIntegrityUnit(unit, new FileSystemHashGenerator()));	
		}
	}

	private static void CheckIntegrity(InMemoryIntegrityDataStore integrityStore) {

		while(true) {
		
			FileSystemDataStore fileStore=new FileSystemDataStore("path");
			FileConsistencyChecker consistencyChecker = new FileConsistencyChecker(null,integrityStore,fileStore);
			consistencyChecker.checkConsistency();
		}
		
		
	}


}
