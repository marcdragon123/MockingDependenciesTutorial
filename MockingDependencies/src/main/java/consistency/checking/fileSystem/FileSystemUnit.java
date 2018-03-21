package consistency.checking.fileSystem;

public abstract class FileSystemUnit {

	FileSystemUnitType type;
	
	public FileSystemUnit(FileSystemUnitType type) {
		this.type=type;
	}
	
	public FileSystemUnitType getFileSystemUnitType() {
		return type;
	}
	
	public abstract String getPath();
	
	public enum FileSystemUnitType{
		File,Directory
	}
}
