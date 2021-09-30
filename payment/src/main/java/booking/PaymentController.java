package booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;


 @RestController
 public class PaymentController {

  PaymentRepository paymentRepository;

  @PostMapping(value = "/approvePay")
  public boolean approvePay(@RequestBody Map<String, String> param) {

   Payment payment = new Payment();
   boolean result = false;

   //String tmp=param.get("id");

   payment.setBookingId(Long.valueOf(param.get("id")));
   payment.setAddr(param.get("addr"));
   payment.setPaymentStatus("COMPLETE_PAYMENT");

   paymentRepository.save(payment);
   result = true;

   System.out.println("\n\n#############Controller안에서  result : " + result + "\n\n");
   return result;
  }

 }