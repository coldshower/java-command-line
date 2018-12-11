# How to run

1. `mvn clean package`
2. `java -jar target/cmd-1.jar [INSERT CMD COMMANDS HERE]`

## Example
```
java -jar target/cmd-1.jar ls .
```

# Commands

## ls [pathname] [-json]

Lists all the files and directories at the given path

```
Example: ls ./testDir -json
```

`-json` will print the output in JSON format


## pwd [pathname]

Prints the absolute version of the given path

```
Example: pwd ../../..
```

## mkdir [pathname]

Creates a directory at the given path

```
Example: mkdir ../siblingOfParent
```

## touch [pathname]

Creates a file at the given path

```
Example: touch newFile.txt
```
