package net.usermd.jrkn87.repositories;

import net.usermd.jrkn87.models.Client;
import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ComplaintRepositoryTest {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Test
    public void testSaveComplaint() {
        Complaint complaint = getComplaint();
        complaintRepository.save(complaint);
        Complaint one = complaintRepository.getOne(complaint.getId());
        assertNotNull(one);
        assertEquals(one.getClient().getClientName(), "Test_");
        assertEquals(one.getProduct().getSerialNumber(), "Test_123");
    }

    @Test
    public void testGetComplaint() {
        Complaint complaint = getComplaintTwo();
        complaintRepository.save(complaint);
        Complaint complaint1 = complaintRepository.getOne(complaint.getId());
        assertNotNull(complaint1);
        assertEquals(complaint1.getClient().getClientName(), "Test_2");
        assertEquals(complaint1.getProduct().getSerialNumber(), "Test_2123");
    }

    @Test
    public void testDeleteAndFindAllComplaint() {
        Complaint complaint = getComplaint();
        Complaint complaintTwo = getComplaintTwo();
        complaintRepository.save(complaint);
        complaintRepository.save(complaintTwo);
        List<Complaint> all = complaintRepository.findAll();
        assertEquals(2, all.size());
        complaintRepository.delete(complaint);
        List<Complaint> allTwo = complaintRepository.findAll();
        assertEquals(1, allTwo.size());
    }

    @Test
    public void testFindAllByIsArchiveIsTrue() {
        Complaint complaint = getComplaint();
        Complaint complaintTwo = getComplaintTwo();
        Complaint complaintThree = getComplaintThree();
        complaintRepository.save(complaint);
        complaintRepository.save(complaintTwo);
        complaintRepository.save(complaintThree);
        List<Complaint> allByIsArchiveIsTrue = complaintRepository.findAllByIsArchiveIsTrue();
        assertEquals(2, allByIsArchiveIsTrue.size());
    }

    @Test
    public void testFindAllByIsArchiveIsFalse() {
        Complaint complaint = getComplaint();
        Complaint complaintTwo = getComplaintTwo();
        Complaint complaintThree = getComplaintThree();
        complaintRepository.save(complaint);
        complaintRepository.save(complaintTwo);
        complaintRepository.save(complaintThree);
        List<Complaint> allByIsArchiveIsFalse = complaintRepository.findAllByIsArchiveIsFalse();
        assertEquals(1, allByIsArchiveIsFalse.size());
    }

    private Complaint getComplaint() {
        Complaint complaint = new Complaint();
        Client client = new Client();
        client.setClientName("Test_");
        client.setAdvertising("Test_");
        client.setEmail("test@test.com");
        client.setNip(1111111111);
        client.setPhoneNumber("111111111");
        Product product = new Product();
        product.setProducer("Test_");
        product.setProductName("Test_");
        product.setSerialNumber("Test_123");
        product.setDeviceStatus("Test_");
        complaint.setArchive(false);
        complaint.setDescription("Test description");
        complaint.setClient(client);
        complaint.setProduct(product);
        return complaint;
    }
    private Complaint getComplaintTwo() {
        Complaint complaint = new Complaint();
        Client client = new Client();
        client.setClientName("Test_2");
        client.setAdvertising("Test_2");
        client.setEmail("test2@test.com");
        client.setNip(1222222222);
        client.setPhoneNumber("222222222");
        Product product = new Product();
        product.setProducer("Test_2");
        product.setProductName("Test_2");
        product.setSerialNumber("Test_2123");
        product.setDeviceStatus("Test_2");
        complaint.setArchive(true);
        complaint.setDescription("Test2 description");
        complaint.setClient(client);
        complaint.setProduct(product);
        return complaint;
    }
    private Complaint getComplaintThree() {
        Complaint complaint = new Complaint();
        Client client = new Client();
        client.setClientName("Test_3");
        client.setAdvertising("Test_3");
        client.setEmail("test3@test.com");
        client.setNip(1333333333);
        client.setPhoneNumber("333333333");
        Product product = new Product();
        product.setProducer("Test_3");
        product.setProductName("Test_3");
        product.setSerialNumber("Test_3123");
        product.setDeviceStatus("Test_3");
        complaint.setArchive(true);
        complaint.setDescription("Test3 description");
        complaint.setClient(client);
        complaint.setProduct(product);
        return complaint;
    }
}
