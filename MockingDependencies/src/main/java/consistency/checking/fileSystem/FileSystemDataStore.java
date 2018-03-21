package consistency.checking.fileSystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.google.common.io.ByteSource;

import consistency.checking.contracts.IDataStore;
import consistency.checking.fileSystem.FileSystemUnit.FileSystemUnitType;

public class FileSystemDataStore implements IDataStore<FileSystemUnit>,Iterable<FileSystemUnit> {
	
	private Directory rootDirectory;

	public FileSystemDataStore(String rootPath) {
		
		getFiles(rootPath);
	}

	/*
	 * hard-coded list of files. needs to get replaced with actual filesystem
	 */
	private void getFiles(String rootPath) {
		
		this.rootDirectory = new Directory(rootPath);

		String file1Path="UserFiles\\Bank Accounts.txt";
		
		FileSystemUnit file1 = new File(
				file1Path,
				getContentOfFile(file1Path));
		
		String file2Path="UserFiles\\Passwords.txt";
		FileSystemUnit file2 = new File(
				file2Path,
				getContentOfFile(file2Path));
		
		String file3Path="UserFiles\\private-photo.txt";
		FileSystemUnit file3 = new File(
				file3Path,
				getContentOfFile(file3Path));
		
		String innerDirPath="UserFiles\\Images";
		Directory innerDir = new Directory(innerDirPath);
		
		String file4Path="UserFiles\\Images\\mom.txt";
		FileSystemUnit file4 = new File(
				file4Path,
				getContentOfFile(file4Path));
		
		String file5Path="UserFiles\\Images\\family.txt";
		FileSystemUnit file5 = new File(
				file5Path,
				getContentOfFile(file5Path));
		
		innerDir.setValue(new FileSystemUnit[] {file4,file5});
		rootDirectory.setValue(new FileSystemUnit[] {file1,file2,file3,innerDir});
		/*try {
		    
			Files.walkFileTree(unitPath, new SimpleFileVisitor<Path>(){
		     
				
				private List<FileSystemUnit> currentUnits;
				private Directory currentDirectory;
				
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					
					if(attrs.isDirectory()){
						
						String directoryPath = file.toString();
						Directory unitDirectory = new Directory(directoryPath);
						currentUnits.add(unitDirectory);
						foundDirectories.add(unitDirectory);
						
					}else {
						
						String filePath = file.toString();
						ByteSource fileContent = com.google.common.io.Files
								.asByteSource(new java.io.File(filePath));
						
						File unitFile = new File(filePath,fileContent);
						currentUnits.add(unitFile);
					}
					
					return FileVisitResult.CONTINUE;
				}
				
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					
					currentDirectory = foundDirectories.stream()
							.filter((directory)->directory.getKey().equals(dir.toString()))
							.findFirst()
							.orElse(null);
					
					currentUnits= new ArrayList<FileSystemUnit>();
					return FileVisitResult.CONTINUE;
				}
				
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					currentDirectory.setValue(currentUnits.toArray(new FileSystemUnit[currentUnits.size()]));
					return FileVisitResult.CONTINUE;
				}
		    });
		} catch (IOException e) {
		      e.printStackTrace();
		}
		*/
	}

	private ByteSource getContentOfFile(String filePath) {
		return  com.google.common.io.Files
				.asByteSource(new java.io.File(filePath));
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
