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

# Include any dependencies generated for this target.
include libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/depend.make

# Include the progress variables for this target.
include libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/progress.make

# Include the compile flags for this target's objects.
include libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/flags.make

libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o: libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/flags.make
libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o: ../libsnark/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o -c /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp

libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.i"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp > CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.i

libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.s"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp -o CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.s

# Object files for target gadgetlib1_fooram_test
gadgetlib1_fooram_test_OBJECTS = \
"CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o"

# External object files for target gadgetlib1_fooram_test
gadgetlib1_fooram_test_EXTERNAL_OBJECTS =

libsnark/gadgetlib1_fooram_test: libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/gadgetlib1/gadgets/cpu_checkers/fooram/examples/test_fooram.cpp.o
libsnark/gadgetlib1_fooram_test: libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/build.make
libsnark/gadgetlib1_fooram_test: libsnark/libsnark.a
libsnark/gadgetlib1_fooram_test: depends/libff/libff/libff.a
libsnark/gadgetlib1_fooram_test: /usr/lib/x86_64-linux-gnu/libgmp.so
libsnark/gadgetlib1_fooram_test: /usr/lib/x86_64-linux-gnu/libgmp.so
libsnark/gadgetlib1_fooram_test: /usr/lib/x86_64-linux-gnu/libgmpxx.so
libsnark/gadgetlib1_fooram_test: depends/libzm.a
libsnark/gadgetlib1_fooram_test: libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable gadgetlib1_fooram_test"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/gadgetlib1_fooram_test.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/build: libsnark/gadgetlib1_fooram_test

.PHONY : libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/build

libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/clean:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && $(CMAKE_COMMAND) -P CMakeFiles/gadgetlib1_fooram_test.dir/cmake_clean.cmake
.PHONY : libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/clean

libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/depend:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : libsnark/CMakeFiles/gadgetlib1_fooram_test.dir/depend

