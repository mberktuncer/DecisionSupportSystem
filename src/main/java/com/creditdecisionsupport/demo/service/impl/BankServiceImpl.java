package com.creditdecisionsupport.demo.service.impl;

import com.creditdecisionsupport.demo.entity.bank.*;
import com.creditdecisionsupport.demo.repository.bank.*;
import com.creditdecisionsupport.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BankServiceImpl implements BankService {

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
    public BankServiceImpl(AkbankRepository akbankRepository, AlbarakaTurkRepository albarakaTurkRepository,
                           DenizbankRepository denizbankRepository, FibabankaRepository fibabankaRepository,
                           GarantiBBVARepository garantiBBVARepository, IsbankRepository isbankRepository,
                           KuveytTurkRepository kuveytTurkRepository, SekerbankRepository sekerbankRepository,
                           TBankRepository tBankRepository, TebRepository tebRepository, VakifbankRepository vakifbankRepository,
                           YapiKrediRepository yapiKrediRepository, ZiraatbankRepository ziraatbankRepository) {


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

    @Transactional
    @Override
    public ResponseEntity<Object> create() {

    this.saveAkbank();
    this.saveAlbaraka();
    this.saveDenizBank();
    this.saveFibabanka();
    this.saveGarantiBBVA();
    this.saveIsbank();
    this.saveKuveytturk();
    this.saveSekerbank();
    this.saveTBank();
    this.saveTebBank();
    this.saveVakifBank();
    this.saveYapiKredi();
    this.saveZiraatBank();

    return ResponseEntity.status(200).body("All banks added");
    }

    public void saveAkbank(){

        Akbank bank = new Akbank();

        bank.setFounder("Haci Sabanci");
        bank.setTier(2);
        bank.setFoundationDate("29 Ocak 1948");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(8245);
        bank.setHousingInterestRating(1.54);

        akbankRepository.save(bank);

    }

    public void saveAlbaraka(){

        AlbarakaTurk bank = new AlbarakaTurk();

        bank.setFounder("Adnan Ahmed Yusuf Abdulmalek");
        bank.setTier(3);
        bank.setFoundationDate("10 Temmuz 1984");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(3899);

        albarakaTurkRepository.save(bank);

    }


    public void saveDenizBank(){

        Denizbank bank = new Denizbank();

        bank.setFounder("Hakan Ateş");
        bank.setTier(3);
        bank.setFoundationDate("11 Nisan 1994");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(4210);

        denizbankRepository.save(bank);

    }

    public void saveFibabanka(){

        Fibabanka bank = new Fibabanka();

        bank.setFounder("Husnu Ozyegin");
        bank.setTier(3);
        bank.setFoundationDate("11 Mart 2010");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(1400);

        fibabankaRepository.save(bank);

    }


    public void saveGarantiBBVA(){

        GarantiBBVA bank = new GarantiBBVA();

        bank.setFounder("Halil Naci Mıhcioglu");
        bank.setTier(1);
        bank.setFoundationDate("11 Nisan 1946");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(18784);

        garantiBBVARepository.save(bank);

    }

    public void saveIsbank(){

        Isbank bank = new Isbank();

        bank.setFounder("Mustafa Kemal Atatürk");
        bank.setTier(1);
        bank.setFoundationDate("26 Agustos 1924");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(16252);

        isbankRepository.save(bank);

    }

    public void saveKuveytturk(){

        KuveytTurk bank = new KuveytTurk();

        bank.setFounder("Kuwait Finance House");
        bank.setTier(3);
        bank.setFoundationDate("26 Aralik 1980");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(1600);

        kuveytTurkRepository.save(bank);

    }

    public void saveSekerbank(){

        Sekerbank bank = new Sekerbank();

        bank.setFounder("Nariman Zharkinbayev");
        bank.setTier(3);
        bank.setFoundationDate("21 Mayis 1953");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(3542);

        sekerbankRepository.save(bank);

    }

    public void saveTBank(){

        TBank bank = new TBank();

        bank.setFounder("Arab Bank");
        bank.setTier(5);
        bank.setFoundationDate("11 Subat 1985");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(450);

        tBankRepository.save(bank);

    }

    public void saveTebBank(){

        Teb bank = new Teb();

        bank.setFounder("BNP Paribas");
        bank.setTier(2);
        bank.setFoundationDate("30 Temmuz 1927");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(8889);

        tebRepository.save(bank);

    }

    public void saveVakifBank(){

        Vakifbank bank = new Vakifbank();

        bank.setFounder("Turkiye");
        bank.setTier(1);
        bank.setFoundationDate("30 Temmuz 1954");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(16835);

        vakifbankRepository.save(bank);

    }

    public void saveYapiKredi(){

        YapiKredi bank = new YapiKredi();

        bank.setFounder("Kazım Taşkent");
        bank.setTier(1);
        bank.setFoundationDate("10 Mayis 1944");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(16631);

        yapiKrediRepository.save(bank);

    }

    public void saveZiraatBank(){

        ZiraatBank bank = new ZiraatBank();

        bank.setFounder("Midhat Pasa");
        bank.setTier(1);
        bank.setFoundationDate("20 Kasim 1863");
        bank.setName(bank.getClass().getSimpleName());
        bank.setNumberOfEmployees(24647);

        ziraatbankRepository.save(bank);

    }
}
