find * -name "*.java" > sources.txt
javac @sources.txt
java com.kvlimon.Main ./utilities/scenario.txt