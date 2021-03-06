package groovy.qrbws.domain

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import qrbws.Person
import qrbws.Status
import qrbws.UserAccount
import spock.lang.Specification

@TestFor(UserAccount)
@Mock([Person, Status])
class UserAccountSpec extends Specification {

    UserAccount userAccount
    def person, status

    def setup() {
        status = new Status(description: 'Activated').save()
        person = new Person(name: "felansu", email: "gaferran@gmail.com").save()
        userAccount = new UserAccount(login: 'teste', password: 'teste', status: status, person: person)
    }

    void "Test that login can't be null or blank"() {

        when: 'the isbn is null'
        userAccount.login = null

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the login is blank'
        userAccount.login = ' '

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the login is filled'
        userAccount.login = 'Teste'

        then: 'validation should pass'
        userAccount.validate()
    }

    void "Test login must be between 5 and 20 characters"() {

        when: 'the login have 4 characters'
        userAccount.login = 'Test'

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the login have 21 characters'
        userAccount.login = '123456789112345678912'

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the login have 8 characters'
        userAccount.login = '12345678'

        then: 'validation should pass'
        userAccount.validate()
    }

    void "Test that login is unique"() {

        when: 'the login repeated try save'
        new UserAccount(login: 'teste', password: 'teste', status: status, person: person).save(flush: true)
        userAccount.login = 'teste'

        then: 'validation should fail'
        !userAccount.validate()
    }

    void "Test that password can't be null or blank"() {

        when: 'the password is null'
        userAccount.password = null

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the password is blank'
        userAccount.password = ' '

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the password is filled'
        userAccount.password = 'senha'

        then: 'validation should pass'
        userAccount.validate()
    }

    void "Test password must be between 5 and 20 characters"() {

        when: 'the password have 4 characters'
        userAccount.password = 'Test'

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the password have 21 characters'
        userAccount.password = '123456789112345678912'

        then: 'validation should fail'
        !userAccount.validate()

        when: 'the password have 8 characters'
        userAccount.password = '12345678'

        then: 'validation should pass'
        userAccount.validate()
    }

    void "Test userAccount need a person for save"() {

        when: 'the person is null'
        userAccount.person = null

        then: 'validation should fail'
        !userAccount.validate()
    }

    void "Test userAccount need a status for save"() {

        when: 'the status is null'
        userAccount.status = null

        then: 'validation should fail'
        !userAccount.validate()
    }
}
