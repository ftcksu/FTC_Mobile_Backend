package sa.edu.ksu.ftc_backend.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.edu.ksu.ftc_backend.Account.Service.AccountService;

import javax.validation.Valid;

@RestController
@RequestMapping("account")
public class AccountController {

    AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    public ResponseEntity createAccount(@RequestBody @Valid Account account){
       return new ResponseEntity(accountService.save(account), HttpStatus.CREATED) ;
    }

    @PutMapping("/")
    public ResponseEntity updateAccount(@RequestBody Account account){
        return new ResponseEntity(accountService.update(account), HttpStatus.OK) ;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id")  Integer id){
        //TODO handle authorization (admin)

        accountService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAccount(@PathVariable("id") Integer id){
        return new ResponseEntity(accountService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllAccounts(){
        return new ResponseEntity(accountService.findAll(), HttpStatus.OK);
    }



}
