package pagerank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class PageRank {
	public static void main(String[] agrs) throws FileNotFoundException {
        File file = new File("");
        String parentPath = file.getAbsoluteFile().getParent();
        System.out.println(parentPath);
        String fileName = "test.txt";
        String outputFileName = "test1.txt";
		String inputFile = parentPath +"\\InputFile\\" + fileName;
				// "C:\\Users\\user-pc\\Desktop\\test2.txt";
				//"E:\\ICT\\DistributedComputing\\Inputfile\\pagerank_10k.txt";
		String outputFile = parentPath + "\\OutputFile\\" + outputFileName;
				// "C:\\Users\\user-pc\\Desktop\\result2.txt";
			//	"E:\\ICT\\DistributedComputing\\OutputFile\\pagerank_10k_6.txt";
		int iteration = 8;
		double dumpingFactor = 0.85;
		long start = System.currentTimeMillis();
		HashMap<Integer, ArrayList<Integer>> adjacencyMatrix = new HashMap<Integer, ArrayList<Integer>>();
		Util.ReadFile(inputFile, adjacencyMatrix);
		int totalURL = adjacencyMatrix.keySet().size();
		Page[] pagerankList = Util.PageRank(adjacencyMatrix, totalURL, dumpingFactor, iteration);
		Util.QuickSort(pagerankList, 0, totalURL - 1);
		Util.WriteFile(pagerankList, outputFile);
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.println("Finished " + time);
	}
}
