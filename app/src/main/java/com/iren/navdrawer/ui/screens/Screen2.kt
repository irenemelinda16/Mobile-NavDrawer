package com.iren.navdrawer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.TrendingUp
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Summary Cards
            Text(
                text = "Ringkasan Statistik",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                SummaryCard(Modifier.weight(1f), "Proyek", "12", Icons.Rounded.RocketLaunch, Color(0xFFE3F2FD), Color(0xFF1976D2))
                Spacer(modifier = Modifier.width(12.dp))
                SummaryCard(Modifier.weight(1f), "Tugas", "48", Icons.Rounded.Task, Color(0xFFF1F8E9), Color(0xFF388E3C))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                SummaryCard(Modifier.weight(1f), "Pesan", "5", Icons.Rounded.Email, Color(0xFFFFF3E0), Color(0xFFF57C00))
                Spacer(modifier = Modifier.width(12.dp))
                SummaryCard(Modifier.weight(1f), "Waktu", "120h", Icons.Rounded.Timer, Color(0xFFF3E5F5), Color(0xFF7B1FA2))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Progress Section
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Progres Bulanan", fontWeight = FontWeight.Bold)
                        Text(text = "75%", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { 0.75f },
                        modifier = Modifier.fillMaxWidth().height(8.dp).background(Color.Transparent, CircleShape),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.primaryContainer,
                        strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Activity List
            Text(
                text = "Aktivitas Terakhir",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            val activities = listOf(
                ActivityItem("Update UI Screen 1", "2 jam yang lalu", Icons.Rounded.Brush, Color(0xFF1976D2)),
                ActivityItem("Refactor Navigation", "5 jam yang lalu", Icons.Rounded.Navigation, Color(0xFF388E3C)),
                ActivityItem("Fix Bug Drawer", "Kemarin", Icons.Rounded.BugReport, Color(0xFFD32F2F)),
                ActivityItem("Meeting Tim", "Kemarin", Icons.Rounded.Groups, Color(0xFF7B1FA2)),
                ActivityItem("Deploy ke Staging", "2 hari yang lalu", Icons.Rounded.CloudUpload, Color(0xFFF57C00))
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(activities) { activity ->
                    ActivityCard(activity)
                }
            }
        }
    }
}

data class ActivityItem(val title: String, val time: String, val icon: ImageVector, val color: Color)

@Composable
fun SummaryCard(modifier: Modifier, title: String, value: String, icon: ImageVector, bgColor: Color, iconColor: Color) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Surface(modifier = Modifier.size(36.dp), shape = RoundedCornerShape(10.dp), color = bgColor) {
                Icon(imageVector = icon, contentDescription = null, modifier = Modifier.padding(8.dp), tint = iconColor)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Composable
fun ActivityCard(activity: ActivityItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(modifier = Modifier.size(40.dp), shape = CircleShape, color = activity.color.copy(alpha = 0.1f)) {
                Icon(imageVector = activity.icon, contentDescription = null, modifier = Modifier.padding(10.dp), tint = activity.color)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = activity.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = activity.time, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
            Icon(Icons.AutoMirrored.Rounded.TrendingUp, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(20.dp))
        }
    }
}
