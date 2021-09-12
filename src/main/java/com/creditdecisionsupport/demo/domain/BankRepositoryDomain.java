package com.creditdecisionsupport.demo.domain;

import com.creditdecisionsupport.demo.entity.bank.*;
import com.creditdecisionsupport.demo.repository.bank.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankRepositoryDomain {
    private final AkbankRepository akbankRepository;
    private final AlbarakaTurkRepository albarakaTurkRepository;
    private final DenizbankRepository denizbankRepository;
    private final FibabankaRepository fibabankaRepository;
    private final GarantiBBVARepository garantiBBVARepository;
    private final IsbankRepository isbankRepository;
    private final KuveytTurkRepository kuveytTurkRepository;
    private final SekerbankRepository sekerbankRepository;
    private final TBankRepository tBankRepository;
    private final TebRepository tebRepository;
    private final VakifbankRepository vakifbankRepository;
    private final YapiKrediRepository yapiKrediRepository;
    private final ZiraatbankRepository ziraatbankRepository;

    @Autowired
    public BankRepositoryDomain(AkbankRepository akbankRepository, AlbarakaTurkRepository albarakaTurkRepository, DenizbankRepository denizbankRepository, FibabankaRepository fibabankaRepository, GarantiBBVARepository garantiBBVARepository, IsbankRepository isbankRepository, KuveytTurkRepository kuveytTurkRepository, SekerbankRepository sekerbankRepository, TBankRepository tBankRepository, TebRepository tebRepository, VakifbankRepository vakifbankRepository, YapiKrediRepository yapiKrediRepository, ZiraatbankRepository ziraatbankRepository) {
        this.akbankRepository = akbankRepository;
        this.albarakaTurkRepository = albarakaTurkRepository;
        this.denizbankRepository = denizbankRepository;
        this.fibabankaRepository = fibabankaRepository;
        this.garantiBBVARepository = garantiBBVARepository;
        this.isbankRepository = isbankRepository;
        this.kuveytTurkRepository = kuveytTurkRepository;
        this.sekerbankRepository = sekerbankRepository;
        this.tBankRepository = tBankRepository;
        this.tebRepository = tebRepository;
        this.vakifbankRepository = vakifbankRepository;
        this.yapiKrediRepository = yapiKrediRepository;
        this.ziraatbankRepository = ziraatbankRepository;
    }

    public <T extends Bank> BankRepository bankRepository(String bank){

        BankRepository bankRepository = null;

        if(bank.equals("Akbank"))
            bankRepository = akbankRepository;

        if(bank.equals("AlbarakaTurk"))
            bankRepository = albarakaTurkRepository;

        if(bank.equals("Denizbank"))
            bankRepository = denizbankRepository;

        if(bank.equals("Fibabanka"))
            bankRepository = fibabankaRepository;

        if(bank.equals("GarantiBBVA"))
            bankRepository = garantiBBVARepository;

        if(bank.equals("Isbank"))
            bankRepository = isbankRepository;

        if(bank.equals("KuveytTurk"))
            bankRepository = kuveytTurkRepository;

        if(bank.equals("Sekerbank"))
            bankRepository = sekerbankRepository;

        if(bank.equals("TBank"))
            bankRepository = tBankRepository;

        if(bank.equals("Teb"))
            bankRepository = tebRepository;

        if(bank.equals("Vakifbank"))
            bankRepository = vakifbankRepository;

        if(bank.equals("YapiKredi"))
            bankRepository = yapiKrediRepository;

        if(bank.equals("ZiraatBank"))
            bankRepository = ziraatbankRepository;

        return bankRepository;
    }
}