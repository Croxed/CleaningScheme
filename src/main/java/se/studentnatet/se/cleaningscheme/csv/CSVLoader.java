package se.studentnatet.se.cleaningscheme.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CSVLoader
{
	/**
	 * Returns a list of user found in CSV
	 *
	 * @param filename
	 * 	path to CSV
	 * @return List of {@link User}s
	 * @throws IOException
	 */
	List<User> loadObjectList(String filename) throws IOException
	{
		// Readers are closable, so put them in a try-with-resource block to automatically close them
		try (Reader reader = Files.newBufferedReader(Paths.get(filename)))
		{
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
			// Java Streams are cool. We use them to minimize the usage of one-line for-loops.
			return StreamSupport.stream(records.spliterator(), false).map(User::fromRecord).collect(Collectors.toList());
		}
	}
}
