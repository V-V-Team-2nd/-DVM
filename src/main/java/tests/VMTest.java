package tests;

import Logic.VM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VMTest {

    String address = "TestAddress";
    String new_address = "NewAddress";
    VM vm = new VM();

    @Test
    public void testGetVmAddress(){
        assertEquals(vm.getVmAddress(), null);
    }

    @Test
    public void testSetVmAddress(){
        vm.setVmAddress(address);
        assertEquals(vm.getVmAddress(), address);
        vm.setVmAddress(new_address);
        assertEquals(vm.getVmAddress(), new_address);
    }

    @Test
    public void testGetIsOperating(){
        assertFalse(vm.getIsOperating());
    }

    @Test
    public void testSetIsOperating(){
        vm.setIsOperating(true);
        assertTrue(vm.getIsOperating());
        vm.setIsOperating(false);
        assertFalse(vm.getIsOperating());
    }
}