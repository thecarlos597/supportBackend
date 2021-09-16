/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.repositories;

import com.neoris.support.entities.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlos.arodriguez
 */
public interface TurnTypeRepository extends JpaRepository<TurnType,Integer> {
    
}
