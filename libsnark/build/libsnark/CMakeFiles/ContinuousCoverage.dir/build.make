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
CMAKE_SOURCE_DIR = /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build

# Utility rule file for ContinuousCoverage.

# Include the progress variables for this target.
include libsnark/CMakeFiles/ContinuousCoverage.dir/progress.make

libsnark/CMakeFiles/ContinuousCoverage:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/ctest -D ContinuousCoverage

ContinuousCoverage: libsnark/CMakeFiles/ContinuousCoverage
ContinuousCoverage: libsnark/CMakeFiles/ContinuousCoverage.dir/build.make

.PHONY : ContinuousCoverage

# Rule to build all files generated by this target.
libsnark/CMakeFiles/ContinuousCoverage.dir/build: ContinuousCoverage

.PHONY : libsnark/CMakeFiles/ContinuousCoverage.dir/build

libsnark/CMakeFiles/ContinuousCoverage.dir/clean:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && $(CMAKE_COMMAND) -P CMakeFiles/ContinuousCoverage.dir/cmake_clean.cmake
.PHONY : libsnark/CMakeFiles/ContinuousCoverage.dir/clean

libsnark/CMakeFiles/ContinuousCoverage.dir/depend:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark/CMakeFiles/ContinuousCoverage.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : libsnark/CMakeFiles/ContinuousCoverage.dir/depend

