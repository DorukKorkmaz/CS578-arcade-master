package edu.usc.softarch.arcade;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import edu.usc.softarch.arcade.facts.driver.CSourceToDepsBuilder;
import edu.usc.softarch.arcade.util.FileUtil;

public class RootRsfWriter {
	
	public static void main(String[] args) throws IOException {
		(new RootRsfWriter()).build(args);
	}
	
	
	public void build(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputDir = FileUtil.tildeExpandPath(args[0]);
		String depsRsfFilename = FileUtil.tildeExpandPath(args[1]);
		FileWriter fstream = new FileWriter(depsRsfFilename);
		BufferedWriter out = new BufferedWriter(fstream);
		
		List<Path> filesInFolder = Files.walk(Paths.get(inputDir))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
		
		for(Path file: filesInFolder) {
			try {
				String fileStr = FileUtil.readFile(file.toString(), StandardCharsets.UTF_8);
				if(fileStr.contains("main(") && fileStr.contains("pipe") && fileStr.contains("chdir(")){
					System.out.println("Root: " + file);
					String filePathStr = file.toString();
					out.write(file.getFileName() + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		out.close();
		
		
	}
	
	
	

}
