package zad2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil implements FileVisitor<Path> {
    static Path scPath;
    static String outFileTxt;
    static FileChannel outputFileChannel;
    int licznik = 0;


    public Futil() throws IOException {
        this.outputFileChannel = FileChannel.open(scPath, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND});
    }

    public static void processDir(String dirName, String resultFileName) {
        outFileTxt = resultFileName;
        scPath = Paths.get(dirName + "/" + resultFileName);
        try {
            Path p1 = Files.walkFileTree(Paths.get(dirName), new Futil());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile() && !file.getFileName().toString().equals(outFileTxt)) {
            System.out.println("plik: " + file.getFileName().toString() + " zostal wczytany");
            licznik++;
            System.out.println("odwiedzono " + licznik);
            FileChannel inputFileChannel = FileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate((int) attrs.size());
            buffer.clear();
            inputFileChannel.read(buffer);
            buffer.flip();
            CharBuffer charBuffer = Charset.forName("Cp1250").decode(buffer);
            ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(charBuffer);
            while (byteBuffer.hasRemaining())
                outputFileChannel.write(byteBuffer);
        }
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
