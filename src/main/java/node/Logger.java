package node;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedList;

import node.blockchain.Block;
import node.blockchain.BlockSkeleton;
import node.blockchain.Transaction;
import node.communication.Address;
import node.communication.BlockSignature;
import node.communication.utils.Utils;

public class Logger {
    
    Node node; 
    InetAddress ip; 
    int debug; 

    public Logger(Node node) {
        this.node = node; 
    }


    public void printPort(int port) {
        try {
            System.out.println("Node up and running on port " + port + " " +  InetAddress.getLocalHost());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e); 
        } 
    }

    public void printTransactionVerify(Transaction transaction) {
        System.out.println("Node " + node.getAddress().getPort() + ": verifyTransaction: " + 
            transaction.getUID() + ", blockchain size: " + node.getBlockchain().size());
    }

    public void printDupTransaction(Transaction transaction, Block block) {
        System.out.println("Node " + node.getAddress().getPort() + ": trans :" + transaction.getUID() + " found in prev block " + block.getBlockId());
    }

    public void printDefiTxInvalid() {
        System.out.println("Node " + node.getAddress().getPort() + "Transaction not valid");
    }

    public void printAddedTransaction() {
        System.out.println("Node " + node.getAddress().getPort() + ": Added transaction. MP:" + node.getMempool().values());
    }

    public void printSQReady(ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + " sent quorum is ready for q: " + quorum);
    }

    public void printSQReconcile() {
        System.out.println("Node " + node.getAddress().getPort() + ": sendQuorumReady RECONCILE");
    }

    public void printSQRException(Address quorumAddress) {
        System.out.println("Node " + node.getAddress().getPort() + ": sendQuorumReady Received IO Exception from node " + quorumAddress.getPort());
    }

    public void printRQReady(ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveQuorumReady invoked for " + quorum );
    }

    public void printNonQMember(ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": not in quorum? q: " + quorum + " my addr: " + node.getAddress());
    }

    public void printRQRException() {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveQuorumReady EOF");
    }

    public void printSentMemHashes() {
        System.out.println("Node " + node.getAddress().getPort() + ": sendMempoolHashes invoked");
    }

    public void printSendRequestedTx(ArrayList<String> hashesRequested) {
        System.out.println("Node " + node.getAddress().getPort() + ": sendMempoolHashes: requested trans: " + hashesRequested);
    }

    public void printMissingRequestedTx() {
        System.out.println("Node " + node.getAddress().getPort() + ": sendMempoolHashes: requested trans not in mempool. MP: " + node.getMempool());
    }

    public void printIOException(IOException e) {
        System.out.println(e);
    }

    public void printException(Exception e) {
        System.out.println(e);
    }

    public void printReceiveMempool() {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveMempool invoked");
    }

    public void printReceiveRequestedTx(ArrayList<String> keysAbsent) {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveMempool requesting transactions for: " + keysAbsent);
    }

    public void printReceivedTx(ArrayList<String> keysAbsent) {
        System.out.println("Node " + node.getAddress().getPort() + ": recieved transactions: " + keysAbsent);
    }

    public void printMempoolRounds(int memPoolRounds) {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveMempool invoked: mempoolRounds: " + memPoolRounds);
    }

    public void printConstructBlock() {
        System.out.println("Node " + node.getAddress().getPort() + ": constructBlock invoked");
    }

    public void printSigOfBlockHash(String blockHash) {
        System.out.println("Node " + node.getAddress().getPort() + ": sendSigOfBlockHash invoked for hash: " + blockHash.substring(0, 4));
    }

    public void printReceiveQuorumSig(int state) {
        System.out.println("Node " + node.getAddress().getPort() + ": 1st part receiveQuorumSignature invoked. state: " + state);
    }

    public void printFalseSig(BlockSignature signature) {
        System.out.println("Node " + node.getAddress().getPort() + ": false sig from " + signature.getAddress());
    }

    public void printReceiveQuorumSig2(BlockSignature signature, ArrayList<BlockSignature> quorumSigs, ArrayList<Address> quorum, Block quorumBlock) {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveQuorumSignature invoked from " + 
                signature.getAddress().toString() + " qSigs: " + quorumSigs + " quorum: " + quorum + " block " + quorumBlock.getBlockId());
    }

    public void printNonRQMember(ArrayList<Address> quorum, int blockId) {
        System.out.println("Node " + node.getAddress().getPort() + ": rQs: not in quorum? q: " + quorum + " my addr: " + node.getAddress() + " block: " + blockId);
    }

    public void printTallyQSigs() {
        System.out.println("Node " + node.getAddress().getPort() + ": tallyQuorumSigs invoked");
    }

    public void printNonTQMember(ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": tQs: not in quorum? q: " + quorum + " my addr: " + node.getAddress());
    }

    public void printQuorumNull() {
        System.out.println("Node " + node.getAddress().getPort() + ": tallyQuorumSigs quorum null");
    }

    public void printWinningHashVotes(HashMap<String, Integer> hashVotes, String winningHash) {
        System.out.println("Node " + node.getAddress().getPort() + ": tallyQuorumSigs: Winning hash votes = " + hashVotes.get(winningHash));
    }

    public void printLosingHash() {
        System.out.println("Node " + node.getAddress().getPort() + ": tallyQuorumSigs: quorumBlockHash does not equals(winningHash)");
    }

    public void printFailedVote(HashMap<String, Integer> hashVotes, Block quorumBlock, String quorumBlockHash, ArrayList<BlockSignature> quorumSigs) {
        System.out.println("Node " + node.getAddress().getPort() + ": tallyQuorumSigs: failed vote. votes: " + hashVotes + " my block " + quorumBlock.getBlockId() + " " + quorumBlockHash.substring(0, 4) +
                " quorumSigs: " + quorumSigs);
    }

    public void printSendSkeleton(ArrayList<BlockSignature> quorumSigs) {
        System.out.println("Node " + node.getAddress().getPort() + ": sendSkeleton invoked. qSigs " + quorumSigs);
    }

    public void printSkeletonQuorumNull() {
        System.out.println("Node " + node.getAddress().getPort() + ": sendSkeleton quorum null");
    }

    public void printSendSkeletonLocal(BlockSkeleton skeleton) {
        System.out.println("Node " + node.getAddress().getPort() + ": sendSkeleton(local) invoked: BlockID " + skeleton.getBlockId());
    }

    public void printReceiveSkeletonLocal(BlockSkeleton blockSkeleton) {
        System.out.println("Node " + node.getAddress().getPort() + ": receiveSkeleton(local) invoked. Hash: " + blockSkeleton.getHash());
    }

    public void printEmptySkeleton(BlockSkeleton blockSkeleton, Block currentBlock, ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": No signatures. blockskeletonID: " + blockSkeleton.getBlockId() + ". CurrentBlockID: " + currentBlock.getBlockId() 
                + " quorum: " + quorum );
    }

    public void printInvalidSig(BlockSkeleton blockSkeleton, Block currentBlock) {
        System.out.println("Node " + node.getAddress().getPort() + ": Failed to validate signature. blockskeletonID: " + blockSkeleton.getBlockId() + ". CurrentBlockID: " + currentBlock.getBlockId());
    }

    public void printSkeletonId(BlockSkeleton blockSkeleton, Block currentBlock, ArrayList<Address> quorum, Address address) {
        System.out.println("Node " + node.getAddress().getPort() + ": blockskeletonID: " + blockSkeleton.getBlockId() + ". CurrentBlockID: " + currentBlock.getBlockId()
                    + " quorum: " + quorum + ". Address: " + address);
    }

    public void printMissingVerifiedSigs(BlockSkeleton blockSkeleton, int verifiedSignatures, ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": sigs not verified for block " + blockSkeleton.getBlockId() + 
                ". Verified sigs: " + verifiedSignatures + ". Needed: " + quorum.size() + " - 1.");
    }

    public void printConstructBlockSkeleton() {
        System.out.println("Node " + node.getAddress().getPort() + ": constructBlockWithSkeleton(local) invoked");
    }

    public void printNewBlock(LinkedList<Block> blockchain, HashMap<String, Transaction> mempool) {
        System.out.println("Node " + node.getAddress().getPort() + ": " + Utils.chainString(blockchain) + " MP: " + mempool.values());
    }

    public void printBlockAdded(Block block, ArrayList<Address> quorum) {
        System.out.println("Node " + node.getAddress().getPort() + ": Added block " + block.getBlockId() + ". Next quorum: " + quorum);
    }

    public void printInterruptedException() {
        System.out.println("Received Interrupted Exception from node " + node.getAddress().getPort());
    }

    public void printConcurrentModificationException(ConcurrentModificationException e) {
        System.out.println(e);
    }

    public void printIndexOutOfBoundsException(IndexOutOfBoundsException e) {
        System.out.println(e);
    }
}