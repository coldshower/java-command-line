# How to run

1. `mvn clean package`
2. `java -jar target/cmd-1.jar [INSERT CMD COMMANDS HERE]`

#### Example
```
java -jar target/cmd-1.jar ls . -json
```

# Commands

## ls

Lists all the files and directories at the given path

`ls [pathname] [-json]`

`-json` will print the output in JSON format

```
# Example:

ls ./testDir -json
```

## pwd

Prints the absolute version of the given path

`pwd [pathname]`

```
# Example:

pwd ../../..
```

## mkdir

Creates a directory at the given path

`mkdir [pathname]`

```
# Example:

mkdir ../siblingOfParent
```

## touch

Creates a file at the given path

`touch [pathname]`

```
# Example: 

touch newFile.txt
```
