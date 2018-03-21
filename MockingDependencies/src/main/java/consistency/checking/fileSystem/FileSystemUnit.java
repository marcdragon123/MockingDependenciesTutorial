package consistency.checking.fileSystem;

public class FileSystemUnit {

	FileSystemUnitType type;
	
	public FileSystemUnit(FileSystemUnitType type) {
		this.type=type;
	}
	
	public FileSystemUnitType getFileSystemUnitType() {
		return type;
	}
	
	
	public enum FileSystemUnitType{
		File,Directory
	}
}
