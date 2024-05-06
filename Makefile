all: clean build run

build:
	@echo "Building..."
	@javac --source-path src -d bin src/Main.java

run:
	@echo "Running..."
	@java -cp bin Main

clean:
	@echo "Cleaning..."
	@rm -rf bin/*