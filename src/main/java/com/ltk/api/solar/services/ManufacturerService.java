package com.ltk.api.solar.services;

//@Service
//@AllArgsConstructor
//public class ManufacturerService {
//
//    private static final Sort SORT_NAME_ASC = Sort.sort(Manufacturer.class)
//            .by(Manufacturer::getName).ascending();
//    private final IManufacturerRepository repository;
//
//    @Transactional
//    public Manufacturer save(Manufacturer city) {
//        return repository.save(city);
//    }
//
//    public boolean existsByName(String name) {
//        return repository.existsByNameEqualsIgnoreCaseAndActiveIsTrue(name);
//    }
//
//    public List<Manufacturer> findAllActive() {
//        return repository.findAllByActiveIsTrue(SORT_NAME_ASC);
//    }
//
//    public Optional<Manufacturer> findById(String id) {
//        return repository.findById(id);
//    }
//
//    public Optional<Manufacturer> findByName(String name) {
//        return repository.findByNameEqualsIgnoreCaseAndActiveIsTrue(name);
//    }
//
//}
