@US007
Feature: Hastalar randevu tarihi oluşturabilmelidir.

  @TC001
  Scenario Outline: TC001 "Kullanıcı geçerli tarih girmelidir. (güncel tarihi veya gelecekteki tarihleri seçebilmelidir)"

    Given Hasta Medunna Ana sayfasına gider
    When Hasta Make an Appointment butonunu basar
    And Hasta First Name "HASTA" girer
    Then 3 saniye bekler
    And Hasta SSN "333-22-1234" girer
    Then 3 saniye bekler
    And Hasta Phone "7678589939" girer
    Then 3 saniye bekler
    And Hasta Last Name "FAİK" girer
    Then 3 saniye bekler
    And Hasta Email "hastafaik@gmail.com" girer
    Then 3 saniye bekler
    And Hasta Appointment DateTime"<Tarih>" girer
    Then 5 saniye bekler
    Examples:
      | Tarih      |
      | 30.11.2022 |
      | 20.12.2022 |
#And sayfayi kapatir
  @TC002
  Scenario: Tarih sırası gün/ay/yıl (ay/gün/yıl) şeklinde olmalıdır.

    Given Hasta Medunna Ana sayfasına gider
    When Hasta Make an Appointment butonunu basar
    And Hasta First Name "HASTA" girer
    Then 3 saniye bekler
    And Hasta SSN "333-22-1234" girer
    Then 3 saniye bekler
    And Hasta Phone "7678589939" girer
    Then 3 saniye bekler
    And Hasta Last Name "FAIK" girer
    Then 3 saniye bekler
    And Hasta Email "hastafaik@gmail.com" girer
    Then 3 saniye bekler
    And Hasta Appointment DateTime"12-12-2022" girer
    Then 5 saniye bekler
    And Hasta doğru tarih  girmiş ise kayıt butonu tıklayarak kayıt olabilir
    #And sayfayi kapatir


  @TC003
  Scenario: API kullanarak randevular görüntülenebilmelidir.

    Given URL:https://www.medunna.com/api/patients/322339
    When User sends GET Request
    Then Status code is 200
    And  "Randevu tarihi" is "12-12-2022"


