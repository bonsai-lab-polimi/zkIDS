# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.16

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build

# Utility rule file for ExperimentalMemCheck.

# Include the progress variables for this target.
include libsnark/CMakeFiles/ExperimentalMemCheck.dir/progress.make

libsnark/CMakeFiles/ExperimentalMemCheck:
	cd /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build/libsnark && /usr/bin/ctest -D ExperimentalMemCheck

ExperimentalMemCheck: libsnark/CMakeFiles/ExperimentalMemCheck
ExperimentalMemCheck: libsnark/CMakeFiles/ExperimentalMemCheck.dir/build.make

.PHONY : ExperimentalMemCheck

# Rule to build all files generated by this target.
libsnark/CMakeFiles/ExperimentalMemCheck.dir/build: ExperimentalMemCheck

.PHONY : libsnark/CMakeFiles/ExperimentalMemCheck.dir/build

libsnark/CMakeFiles/ExperimentalMemCheck.dir/clean:
	cd /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build/libsnark && $(CMAKE_COMMAND) -P CMakeFiles/ExperimentalMemCheck.dir/cmake_clean.cmake
.PHONY : libsnark/CMakeFiles/ExperimentalMemCheck.dir/clean

libsnark/CMakeFiles/ExperimentalMemCheck.dir/depend:
	cd /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/libsnark /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build/libsnark /home/davide/Scrivania/ZeroKnowledge/Middlebox/libsnark/build/libsnark/CMakeFiles/ExperimentalMemCheck.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : libsnark/CMakeFiles/ExperimentalMemCheck.dir/depend
