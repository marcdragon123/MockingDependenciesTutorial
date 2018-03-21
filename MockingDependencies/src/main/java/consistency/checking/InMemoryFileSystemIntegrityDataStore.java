package consistency.checking;

import java.util.HashMap;

import consistency.checking.contracts.IDataStore;
import consistency.checking.contracts.IDataUnit;

/*
 * Holds FileSystemUnits (File/Directory) and their corresponding hash values
 */
public class InMemoryFileSystemIntegrityDataStore implements IDataStore<FileSystemIntegrityUnit>{

	
	private HashMap<String,FileSystemIntegrityUnit> map= new HashMap<String,FileSystemIntegrityUnit>();

	/*
	 * returns the computed hash of a File System Unit (File/Directory)
	 */
	@Override
	public FileSystemIntegrityUnit getDataUnit(String unitPath) {
		return map.get(unitPath);
	}

	@Override
	public void store(FileSystemIntegrityUnit unit) {
		map.put(unit.getKey(), unit);
	}

}
