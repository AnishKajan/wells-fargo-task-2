package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "financial_advisors")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    protected FinancialAdvisor() { }               // JPA needs it

    public FinancialAdvisor(String name) {
        this.name = name;
    }

    public Long getAdvisorId() { return advisorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}
