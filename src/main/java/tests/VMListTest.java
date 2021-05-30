package tests;

import Logic.VMList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VMListTest {
    VMList vmList = new VMList();
    @Test
    void getSelectedVMAddress() {
        assertEquals(vmList.getSelectedVMAddress(0), null);
        assertEquals(vmList.getSelectedVMAddress(1), null);
        vmList.addVM(1,"편의점");
        assertEquals(vmList.getSelectedVMAddress(0), "편의점");
        assertEquals(vmList.getSelectedVMAddress(3), null);
        assertEquals(vmList.getSelectedVMAddress(4), null);
        assertEquals(vmList.getSelectedVMAddress(5), null);
        vmList.addVM(5,"건대입구역");
        assertEquals(vmList.getSelectedVMAddress(4), "건대입구역");
        assertEquals(vmList.getSelectedVMAddress(6), null);
        vmList.addVM(8,"인천공항");
        assertEquals(vmList.getSelectedVMAddress(7), "인천공항");
        assertEquals(vmList.getSelectedVMAddress(9), null);
    }

    @Test
    public void testGetSetMyID(){
        int id = 3;
        vmList.setMyID(id);
        assertEquals(vmList.getMyID(), id);
        id = 5;
        vmList.setMyID(id);
        assertEquals(vmList.getMyID(), id);
    }

    @Test
    public void testGetSetMyAddress(){
        String address = "TestAddress";
        vmList.setMyAddress(address);
        assertEquals(vmList.getMyAddress(), address);
        address = "NewAddress";
        vmList.setMyAddress(address);
        assertEquals(vmList.getMyAddress(), address);
    }


}