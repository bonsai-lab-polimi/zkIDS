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
include libsnark/CMakeFiles/test_set_commitment_gadget.dir/depend.make

# Include the progress variables for this target.
include libsnark/CMakeFiles/test_set_commitment_gadget.dir/progress.make

# Include the compile flags for this target's objects.
include libsnark/CMakeFiles/test_set_commitment_gadget.dir/flags.make

libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o: libsnark/CMakeFiles/test_set_commitment_gadget.dir/flags.make
libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o: ../libsnark/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o -c /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp

libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.i"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp > CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.i

libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.s"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp -o CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.s

# Object files for target test_set_commitment_gadget
test_set_commitment_gadget_OBJECTS = \
"CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o"

# External object files for target test_set_commitment_gadget
test_set_commitment_gadget_EXTERNAL_OBJECTS =

libsnark/test_set_commitment_gadget: libsnark/CMakeFiles/test_set_commitment_gadget.dir/gadgetlib1/gadgets/set_commitment/tests/test_set_commitment_gadget.cpp.o
libsnark/test_set_commitment_gadget: libsnark/CMakeFiles/test_set_commitment_gadget.dir/build.make
libsnark/test_set_commitment_gadget: libsnark/libsnark.a
libsnark/test_set_commitment_gadget: depends/libff/libff/libff.a
libsnark/test_set_commitment_gadget: /usr/lib/x86_64-linux-gnu/libgmp.so
libsnark/test_set_commitment_gadget: /usr/lib/x86_64-linux-gnu/libgmp.so
libsnark/test_set_commitment_gadget: /usr/lib/x86_64-linux-gnu/libgmpxx.so
libsnark/test_set_commitment_gadget: depends/libzm.a
libsnark/test_set_commitment_gadget: libsnark/CMakeFiles/test_set_commitment_gadget.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable test_set_commitment_gadget"
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/test_set_commitment_gadget.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
libsnark/CMakeFiles/test_set_commitment_gadget.dir/build: libsnark/test_set_commitment_gadget

.PHONY : libsnark/CMakeFiles/test_set_commitment_gadget.dir/build

libsnark/CMakeFiles/test_set_commitment_gadget.dir/clean:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark && $(CMAKE_COMMAND) -P CMakeFiles/test_set_commitment_gadget.dir/cmake_clean.cmake
.PHONY : libsnark/CMakeFiles/test_set_commitment_gadget.dir/clean

libsnark/CMakeFiles/test_set_commitment_gadget.dir/depend:
	cd /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark /home/davide/Scrivania/ZeroKnowledge/zkfw_new/zkfw/libsnark/build/libsnark/CMakeFiles/test_set_commitment_gadget.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : libsnark/CMakeFiles/test_set_commitment_gadget.dir/depend

