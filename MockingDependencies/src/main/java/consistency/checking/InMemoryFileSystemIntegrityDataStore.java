package consistency.checking;

import java.util.HashMap;

import consistency.checking.contracts.IDataStore;
import consistency.checking.contracts.IDataUnit;

public class InMemoryFileSystemIntegrityDataStore implements IDataStore<FileSystemIntegrityUnit>{

	
	private HashMap<String,FileSystemIntegrityUnit> map;

	@Override
	public FileSystemIntegrityUnit getDataUnit(String key) {
		return map.get(key);
	}

	@Override
	public void store(FileSystemIntegrityUnit unit) {
		map.put(unit.getKey(), unit);
	}

}
