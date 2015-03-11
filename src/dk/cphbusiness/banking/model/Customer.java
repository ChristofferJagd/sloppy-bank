package dk.cphbusiness.banking.model;

import dk.cphbusiness.banking.model.Account;
import java.util.Collection;

public interface Customer {
  int getId();
  String getName();
  Account findAccount(String number);
  Collection<Account> listAccounts();
  void addAccount(Account account);
  }
