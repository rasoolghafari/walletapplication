package com.rasoolghafari.walletapplication.mapper;

import com.rasoolghafari.walletapplication.dto.BalanceDTO;
import com.rasoolghafari.walletapplication.dto.WalletDTO;
import com.rasoolghafari.walletapplication.model.Wallet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface WalletMapper {
    WalletDTO toDto(Wallet entity);

    BalanceDTO toBalanceDto(Wallet entity);

    Wallet toEntity(WalletDTO dto);
}