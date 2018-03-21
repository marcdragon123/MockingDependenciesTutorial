package consistency.checking.fileSystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;

import consistency.checking.contracts.IDataStore;

public class FileSystemDataStore implements IDataStore<FileSystemUnit>,Iterable<FileSystemUnit> {
	
	private String path;
	private Directory rootDirectory;

	public FileSystemDataStore(String path) {
		this.path=path;
		
		// we should initialize rootDirectory here with all its inner files and directories
		Path unitPath= Paths.get(path);
		/*final List<Path> files=new ArrayList<>();
		 try {
		    Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
		     @Override
		     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		          if(!attrs.isDirectory()){
		               files.add(file);
		          }
		          return FileVisitResult.CONTINUE;
		      }
		     });
		 } catch (IOException e) {
		      e.printStackTrace();
		 }*/
		
	}

	@Override
	public FileSystemUnit getDataUnit(String unitPath) {
		return null;
	}

	@Override
	public void store(FileSystemUnit unit) {
		
		if(unit instanceof File)
			store((File)unit);
		else
			store((Directory)unit);
	}
	
	private void store(File file) {}
	
	private void store(Directory directory) {}

	@Override
	public Iterator<FileSystemUnit> iterator() {
		
		return new DirectoryIterator(rootDirectory);
	}
		
}
