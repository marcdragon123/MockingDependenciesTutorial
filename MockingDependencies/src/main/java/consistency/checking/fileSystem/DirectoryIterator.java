package consistency.checking.fileSystem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Iterates recursively over the units (Files and Directories) contained in a directory
 */
public class DirectoryIterator implements Iterator<FileSystemUnit> {

	
	Queue<FileSystemUnit> notVisitedUnits= new LinkedList<FileSystemUnit>();
	
	public DirectoryIterator(Directory directory) {
		notVisitedUnits.add(directory);
	}
	
	@Override
	public boolean hasNext() {

		return !this.notVisitedUnits.isEmpty();
	}

	@Override
	public FileSystemUnit next() {

		FileSystemUnit next=notVisitedUnits.remove();
		
		if(next instanceof Directory)
		{
			Directory nextDirectory=(Directory)next;
			
			for(FileSystemUnit unit:nextDirectory.getValue())
				notVisitedUnits.add(unit);	
		}
		
		return next;
	}

}
